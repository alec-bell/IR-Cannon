package software.snowball.loworbitircannon;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.ConsumerIrManager;
import android.preference.PreferenceFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonRectangle;

public class MainActivity extends AppCompatActivity {


    //another good site: irdb.tk
    //NOTE: NEC is the only brand that's supported as of now
    //NOTE: isFirstRun() is always true right now, for testing purposes.  it can be changed in the checkFirstRun() method.

    ConsumerIrManager ir;
    IRUtil irUtil;

    Toolbar toolbar;
    private final String[] brands = {"NEC", "SAMSUNG", "EPSON"};
    /*
    ButtonRectangle power;
    */
    ButtonRectangle powerOn;
    ButtonRectangle powerOff;
    ButtonRectangle video;
    ButtonRectangle focusp; //focus in
    ButtonRectangle focusm; //focus out
    ButtonRectangle brightnessp; //raise brightness
    ButtonRectangle brightnessm; //lower brightness
    ButtonRectangle zoomp;
    ButtonRectangle zoomm;
    ButtonRectangle rapid;
    ButtonRectangle spring;
    ButtonRectangle delayedPower;
    ButtonRectangle delayedRapid;
    TextView brand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set up toolbar
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        //initializing objects
        /*
        power = (ButtonRectangle) findViewById(R.id.btnPower);
        */
        powerOn = (ButtonRectangle) findViewById(R.id.btnPowerOn);
        powerOff = (ButtonRectangle) findViewById(R.id.btnPowerOff);
        video = (ButtonRectangle) findViewById(R.id.btnInput);
        focusp = (ButtonRectangle) findViewById(R.id.btnFocusP);
        focusm = (ButtonRectangle) findViewById(R.id.btnFocusM);
        brightnessp = (ButtonRectangle) findViewById(R.id.btnBrightnessp);
        brightnessm = (ButtonRectangle) findViewById(R.id.btnBrightnessm);
        zoomp = (ButtonRectangle) findViewById(R.id.btnZoomp);
        zoomm = (ButtonRectangle) findViewById(R.id.btnZoomm);
        rapid = (ButtonRectangle) findViewById(R.id.btnRapid);
        spring = (ButtonRectangle) findViewById(R.id.btnSpring);
        delayedPower = (ButtonRectangle) findViewById(R.id.btnDelayOff);
        delayedRapid = (ButtonRectangle) findViewById(R.id.btnDelayRapid);
        brand = (TextView) findViewById(R.id.tvBrand);
        irUtil = new IRUtil(getApplicationContext());
        /**
         * 4/6/16: disabling first run dialog for now, defaulting brand to NEC automatically
         * checkFirstRun();
         */
        setBrand("NEC");

        //setting listeners to handle clicking
        /*
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.power();
            }
        });
        */
        powerOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.powerOn();
            }
        });

        powerOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.powerOff();
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.input();
            }
        });
        focusp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.focusP();
            }
        });
        focusm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.focusM();
            }
        });
        brightnessp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.brightnessP();
            }
        });
        brightnessm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.brightnessM();
            }
        });
        zoomp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.zoomP();
            }
        });
        zoomm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.zoomM();
            }
        });
        rapid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.rapidMode();
            }
        });
        spring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.springMode();
            }
        });
        delayedPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDelayDialog("poweroff");
            }
        });
        delayedRapid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDelayDialog("rapid");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //about and settings options on toolbar
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_about:
                Intent about = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(about);
                return true;
            case R.id.action_settings:
                Intent settings = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(settings);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setBrand(String b) {
        irUtil.setCurBrand(b.toUpperCase());
        brand.setText(b + " Device Remote");
    }

    public void checkFirstRun() {
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        //isFirstRun = true; //for testing purposes only
        if (isFirstRun) {
            //prompt user for brand
            showInputDialog();
            //modify isFirstRun to be false
            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun", false)
                    .apply();
        }
    }

    protected void showDelayDialog(String function) {
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View promptView = layoutInflater.inflate(R.layout.delay_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(promptView);
        final String f = function;

        final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
        //setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean isValid = true;
                        int temp = Integer.parseInt(editText.getText().toString());
                        if (temp < 200) {
                            isValid = false;
                            Toast.makeText(getApplicationContext(), "Error! Desired time is too short!", Toast.LENGTH_LONG);
                        }
                        if (temp > 30000) {
                            isValid = false;
                            Toast.makeText(getApplicationContext(), "Error! Desired time is too long!", Toast.LENGTH_LONG);
                        }

                        if (isValid) {
                            //note: converts time from seconds to milliseconds (seconds are more input friendly
                            irUtil.delayedFunction(temp * 1000, f);
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //don't run method
                        dialog.cancel();
                    }
                });
        //creating the dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    protected void showInputDialog() {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View promptView = layoutInflater.inflate(R.layout.input_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (!editText.getText().toString().matches("")) {
                            boolean isValid = false;
                            for (int i = 0; i < brands.length; i++) {
                                if (brands[i].equals(editText.getText().toString().toUpperCase().trim())) {
                                    isValid = true;
                                    break;
                                }
                            }
                            if (isValid) {
                                setBrand(editText.getText().toString().toUpperCase().trim());
                            } else {
                                Toast.makeText(getApplicationContext(), "Brand not found! Defaulting to NEC", Toast.LENGTH_LONG).show();
                                setBrand("NEC");
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Brand not found! Defaulting to NEC", Toast.LENGTH_LONG).show();
                            setBrand("NEC");
                        }
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //default brand to NEC
                                irUtil.setCurBrand("NEC");
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }

    public static class SettingsFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.pref_general);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = super.onCreateView(inflater, container, savedInstanceState);
            view.setBackgroundColor(getResources().getColor(android.R.color.white));
            return view;
        }
    }
}

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
import android.widget.Button;
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
    private boolean isOn;

    Button power;
    //Button powerOn;
    //Button powerOff;
    Button video;
    Button picmute; //mutes picture
    Button keylock;
    Button setup; //random menu that serves unknown purpose (for testing purposes)
    Button focusp; //focus in
    Button focusm; //focus out
    Button brightnessp; //raise brightness
    Button brightnessm; //lower brightness
    Button zoomp;
    Button zoomm;
    Button rapid;
    Button spring;
    Button select;
    Button up;
    Button down;
    Button left;
    Button right;
    Button volUp;
    Button volDown;

    //Button delayedPower;
    //Button delayedRapid;
    TextView brand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set up toolbar
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        isOn = false;

        //initializing objects

        power = (Button) findViewById(R.id.btnPower);

        //powerOn = (Button) findViewById(R.id.btnPowerOn);
        //powerOff = (Button) findViewById(R.id.btnPowerOff);
        video = (Button) findViewById(R.id.btnInput);
        picmute = (Button) findViewById(R.id.btnPicMute);
        //keylock = (Button) findViewById(R.id.btnKeyLock);
        //setup = (Button) findViewById(R.id.btnSetup);
        focusp = (Button) findViewById(R.id.btnFocusP);
        focusm = (Button) findViewById(R.id.btnFocusM);
        brightnessp = (Button) findViewById(R.id.btnBrightnessp);
        brightnessm = (Button) findViewById(R.id.btnBrightnessm);
        zoomp = (Button) findViewById(R.id.btnZoomp);
        zoomm = (Button) findViewById(R.id.btnZoomm);
        rapid = (Button) findViewById(R.id.btnRapid);
        spring = (Button) findViewById(R.id.btnSpring);
        select = (Button) findViewById(R.id.btnOK);
        up = (Button) findViewById(R.id.btnPageUp);
        down = (Button) findViewById(R.id.btnPageDown);
        left = (Button) findViewById(R.id.btnPageLeft);
        right = (Button) findViewById(R.id.btnPageRight);
        volUp = (Button) findViewById(R.id.btnVolumeUp);
        volDown = (Button) findViewById(R.id.btnVolumeDown);
        //delayedPower = (Button) findViewById(R.id.btnDelayOff);
        //delayedRapid = (Button) findViewById(R.id.btnDelayRapid);
        brand = (TextView) findViewById(R.id.tvBrand);
        irUtil = new IRUtil(getApplicationContext());
        /**
         * 4/6/16: disabling first run dialog for now, defaulting brand to NEC automatically
         * checkFirstRun();
         */
        setBrand("NEC");

        //setting listeners to handle clicking

        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOn) {
                    irUtil.powerOff();
                    power.setBackgroundColor(Color.rgb(20, 90, 50));
                    isOn = false;
                } else {
                    irUtil.powerOn();
                    power.setBackgroundColor(Color.rgb(146, 43, 33));
                    isOn = true;
                }
            }
        });
        /*
        powerOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.powerOn();
            }
        });
        */
        /*
        powerOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.powerOff();
            }
        });
        */
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.input();
            }
        });
        picmute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.pictureMute();
            }
        });
        /*keylock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.keyLock();
            }
        });*/
        /*setup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.setup();
            }
        });*/
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
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.select();
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.up();
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.down();
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.left();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.right();
            }
        });
        volUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.volUp();
            }
        });
        volDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.volDown();
            }
        });
        /*
        delayedPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDelayDialog("poweroff");
            }
        });
        */
        /*
        delayedRapid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDelayDialog("rapid");
            }
        });
        */
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
                        if (temp < 2) {
                            isValid = false;
                            Toast.makeText(getApplicationContext(), "Error! Desired time is too short!", Toast.LENGTH_LONG);
                        }
                        if (temp > 120) {
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

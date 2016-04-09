package software.snowball.loworbitircannon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.hardware.ConsumerIrManager;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConsumerIrManager ir;
    IRUtil irUtil;

    Toolbar toolbar;
    private final String[] brands = {"NEC", "SAMSUNG", "EPSON"};
    private boolean isOn;
    private String deviceType;

    Button power;
    Button video;
    Button picmute; //mutes picture
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
        video = (Button) findViewById(R.id.btnInput);
        picmute = (Button) findViewById(R.id.btnPicMute);
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
        brand = (TextView) findViewById(R.id.tvBrand);
        irUtil = new IRUtil(getApplicationContext());

        deviceType = "Projector";
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
                    irUtil.powerOff();
                    power.setBackgroundColor(Color.rgb(146, 43, 33));
                    isOn = true;
                }
            }
        });
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
        brand.setText(b + " " + deviceType + " Remote");
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        //set if there is a delay or not
        boolean defaultEnableDelay = getResources().getBoolean(R.bool.toggle_delay_switch);
        boolean enableDelay = preferences.getBoolean("toggle_delay_switch", defaultEnableDelay);
        irUtil.setDelay(enableDelay);

        //set time of delay based on preferences
        String defaultDelayTime = getResources().getString(R.string.delay_time);
        String delayTime = preferences.getString("delay_time", defaultDelayTime);
        irUtil.setDelayTime(Integer.valueOf(delayTime));

        //set brand of device
        String defaultBrandName = getResources().getString(R.string.pref_general_brand);
        String brandName = preferences.getString("brand", defaultBrandName);
        irUtil.setCurBrand(brandName);


        //set type of device
        String defaultDeviceType = getResources().getString(R.string.pref_general_device);
        String deviceType = preferences.getString("device", defaultDeviceType);

        brand.setText(brandName + " " + deviceType + " Remote");
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

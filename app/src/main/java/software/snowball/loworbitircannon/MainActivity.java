package software.snowball.loworbitircannon;

import android.content.Intent;
import android.hardware.ConsumerIrManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    //another good site: irdb.tk
    //NOTE: NEC is the only brand that's supported as of now

    ConsumerIrManager ir;
    IRUtil irUtil;

    Toolbar toolbar;

    Button power;
    Button powerOn;
    Button powerOff;
    Button video;
    Button focusp; //focus in
    Button focusm; //focus out
    Button brightnessp; //raise brightness
    Button brightnessm; //lower brightness
    Button zoomp;
    Button zoomm;
    Button rapid;
    Button spring;
    //We need to eventually add the options button to toolbar, and put settings and about buttons in there

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up toolbar
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        //initializing objects
        power = (Button) findViewById(R.id.btnPower);
        powerOn = (Button) findViewById(R.id.btnPowerOn);
        powerOff = (Button) findViewById(R.id.btnPowerOff);
        video = (Button) findViewById(R.id.btnInput);
        focusp = (Button) findViewById(R.id.btnFocusP);
        focusm = (Button) findViewById(R.id.btnFocusM);
        brightnessp = (Button) findViewById(R.id.btnBrightnessp);
        brightnessm = (Button) findViewById(R.id.btnBrightnessm);
        zoomp = (Button) findViewById(R.id.btnZoomp);
        zoomm = (Button) findViewById(R.id.btnZoomm);
        rapid = (Button) findViewById(R.id.btnRapid);
        spring = (Button) findViewById(R.id.btnSpring);

        irUtil = new IRUtil(getApplicationContext());

        //setting listeners to handle clicking
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irUtil.power();
            }
        });
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
                //Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                //startActivity(intent);
                return true;
            case R.id.action_settings:
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

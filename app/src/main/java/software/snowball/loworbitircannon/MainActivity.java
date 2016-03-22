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

import com.gc.materialdesign.views.ButtonRectangle;
import com.gc.materialdesign.widgets.Dialog;

public class MainActivity extends AppCompatActivity {


    //another good site: irdb.tk
    //NOTE: NEC is the only brand that's supported as of now

    ConsumerIrManager ir;
    IRUtil irUtil;

    Toolbar toolbar;

    ButtonRectangle power;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set up toolbar
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        //initializing objects
        power = (ButtonRectangle) findViewById(R.id.btnPower);
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

}

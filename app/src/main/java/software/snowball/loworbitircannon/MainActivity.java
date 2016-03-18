package software.snowball.loworbitircannon;

import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import android.util.SparseArray;

public class MainActivity extends AppCompatActivity {


    //another good site: irdb.tk
    //NOTE: NEC is the only brand that's supported as of now

    ConsumerIrManager ir;
    Button power;
    Button powerOn;
    Button powerOff;
    Button video;
    Button focusp; //focus in
    Button focusm; //focus out
    Button rapid;
    int fr;
    //IR codes for NEC
    final int[] NECp = {9024, 4512, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 564, 564, 1692, 564,
            564, 564, 564, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 564, 564,
            564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 1692, 564, 40884};
    final int[] NECpOn = {9024, 4512, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 564,
            564, 1692, 564, 564, 564, 564, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 564,
            564, 564, 564, 1692, 564, 564, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 564,
            564, 1692, 564, 1692, 564, 1692, 564, 1692, 564, 40884};
    final int[] NECpOff = {9024, 4512, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 564, 564, 1692, 564,
            564, 564, 564, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 1692, 564, 564, 564, 1692, 564,
            564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 40884};
    final int[] NECinput = {9024, 4512, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 564,
            564, 1692, 564, 564, 564, 564, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 564, 564,
            1692, 564, 1692, 564, 564, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 1692, 564,
            1692, 564, 1692, 564, 1692, 564, 40884};
    final int[] NECfocusp = {9024, 4512, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 564, 564, 1692, 564,
            564, 564, 564, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 1692, 564, 564, 564,
            564, 564, 564, 564, 1692, 564, 564, 564, 564, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 40884};
    final int[] NECfocusm = {9024, 4512, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 564, 564, 1692, 564,
            564, 564, 564, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 564,
            564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 40884};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing objects
        power = (Button) findViewById(R.id.btnPower);
        powerOn = (Button) findViewById(R.id.btnPowerOn);
        powerOff = (Button) findViewById(R.id.btnPowerOff);
        video = (Button) findViewById(R.id.btnInput);
        focusp = (Button) findViewById(R.id.btnFocusP);
        focusm = (Button) findViewById(R.id.btnFocusM);
        rapid = (Button) findViewById(R.id.btnRapid);


        ir = (ConsumerIrManager)getSystemService(Context.CONSUMER_IR_SERVICE);

        fr = 37000;

        if (ir.hasIrEmitter()) {
            ConsumerIrManager.CarrierFrequencyRange[] freqs = ir.getCarrierFrequencies();
            for (ConsumerIrManager.CarrierFrequencyRange range : freqs) {
                fr = range.getMaxFrequency();
            }
        }

        //setting listeners to handle clicking
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ir.hasIrEmitter()) {
                    return;
                }

                ir.transmit(fr, NECp);
            }
        });

        powerOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ir.hasIrEmitter()) {
                    return;
                }

                ir.transmit(fr, NECpOn);
            }
        });

        powerOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ir.hasIrEmitter()) {
                    return;
                }

                ir.transmit(fr, NECpOff);
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ir.hasIrEmitter()) {
                    return;
                }

                ir.transmit(fr, NECinput);
            }
        });

        focusp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ir.hasIrEmitter()) {
                    return;

                }
                ir.transmit(fr, NECfocusp);
            }
        });

        focusm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ir.hasIrEmitter()) {
                    return;

                }
                ir.transmit(fr, NECfocusm);
            }
        });

        rapid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rapidMode();
            }
        });
    }

    public void rapidMode() {
        if (!ir.hasIrEmitter()) {
            return;
        }

        //either loop here or just start runnable
        new Thread(new Runnable() {
            Random rnd = new Random();
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    int t = rnd.nextInt(3);
                    if (t == 0) {
                        ir.transmit(fr, NECfocusp);
                    } else if (t == 1) {
                        ir.transmit(fr, NECfocusm);
                    } else {
                        ir.transmit(fr ,NECinput);
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}

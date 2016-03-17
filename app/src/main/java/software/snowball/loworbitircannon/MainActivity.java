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
import android.util.SparseArray;

public class MainActivity extends AppCompatActivity {

    //codes available here http://www.remotecentral.com/cgi-bin/codes/nec/mt-820/
    //another good site: irdb.tk

    ConsumerIrManager ir;
    Button powerOn;
    Button powerOff;
    Button menu;
    Button input;
    int fr;
    final int[] pOn = {9024, 4512, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 564,
            564, 1692, 564, 564, 564, 564, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 564,
            564, 564, 564, 1692, 564, 564, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 564,
            564, 1692, 564, 1692, 564, 1692, 564, 1692, 564, 40884};

    final int[] pOff = {0, 106, 0, 2, 0, 176, 0, 22, 0, 22, 0, 22, 0, 66, 0, 66, 0, 22, 0, 22, 0, 23, 0, 66, 0, 22, 0, 22,
            0, 66, 0, 22, 0, 66, 0, 66, 0, 66, 0, 22, 0, 22, 0, 66, 0, 22, 0, 66, 0, 22, 0, 22, 0, 23, 0, 66, 0, 66, 0, 22,
            0, 66, 0, 22, 0, 66, 0, 66, 0, 66, 0, 1492, 0, 88, 0, 3664};
    final int[] men = {9024, 4512, 564, -564, 564, -564, 564, -564, 564, -1692, 564, -1692, 564, -564, 564, -564, 564, -564, 564, -1692, 564, -564, 564, -564, 564, -1692, 564, -564, 564, -1692, 564, -1692, 564, -1692, 564, -564, 564, -564, 564, -1692, 564, -1692, 564, -564, 564, -564, 564, -564, 564, -564, 564, -1692, 564, -1692, 564, -564, 564, -564, 564, -1692, 564, -1692, 564, -1692, 564, -1692, 564, -40884};


    final int[] vid = {0, 106, 0, 2, 0, 176, 0, 22, 0, 22, 0, 22, 0, 66, 0, 66, 0, 22, 0, 22, 0, 23, 0, 66, 0, 22, 0, 22, 0,
            66, 0, 22, 0, 66, 0, 66, 0, 66, 0, 66, 0, 66, 0, 22, 0, 22, 0, 22, 0, 22, 0, 22, 0, 22, 0, 22, 0, 22, 0, 66, 0,
            66, 0, 66, 0, 66, 0, 66, 0, 66, 0, 1493, 0, 88, 0, 3665};
    final int[] samsungMen = {0, 108, 0, 34, 173, 173, 22, 65, 22, 65, 22, 65, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 65,
            22, 65, 22, 65, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 65, 22, 22, 22, 65, 22, 65, 22, 22, 22, 22, 22,
            22, 22, 65, 22, 22, 22, 65, 22, 22, 22, 22, 22, 65, 22, 65, 22, 65, 22, 1787};
    final int[] samsungP = {0, 109, 34, 3, 169, 168, 21, 63, 21, 63, 21, 63, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 63, 21,
            63, 21, 63, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 63, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21,
            21, 64, 21, 21, 21, 63, 21, 63, 21, 63, 21, 63, 21, 63, 21, 63, 21, 1794, 169, 168, 21, 21, 21, 3694};
    final int[] samsungM = {0, 109, 34, 3, 169, 168, 21, 63, 21, 63, 21, 63, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 63, 21,
            63, 21, 63, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 63, 21, 21, 21, 63, 21, 63, 21, 21, 21, 21, 21, 21,
            21, 63, 21, 21, 21, 63, 21, 21, 21, 21, 21, 63, 21, 63, 21, 63, 21, 1795, 169, 168, 21, 21, 21, 3694};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing objects
        powerOn = (Button) findViewById(R.id.btnPowerOn);
        powerOff = (Button) findViewById(R.id.btnPowerOff);
        menu = (Button) findViewById(R.id.btnMenu);
        input = (Button) findViewById(R.id.btnInput);
        ir = (ConsumerIrManager)getSystemService(Context.CONSUMER_IR_SERVICE);

        fr = 38400;

        if (ir.hasIrEmitter()) {
            ConsumerIrManager.CarrierFrequencyRange[] freqs = ir.getCarrierFrequencies();
            for (ConsumerIrManager.CarrierFrequencyRange range : freqs) {
                fr = range.getMaxFrequency();
            }
        }


        //setting listeners to handle clicking
        powerOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ir.hasIrEmitter()) {
                    return;
                }

                ir.transmit(37000, pOn);
            }
        });

        powerOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ir.hasIrEmitter()) {
                    return;
                }

                ir.transmit(fr, pOff);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ir.hasIrEmitter()) {
                    return;
                }

                ir.transmit(37000, men);
            }
        });

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ir.hasIrEmitter()) {
                    return;
                }

                ir.transmit(fr, vid);
            }
        });

    }

}

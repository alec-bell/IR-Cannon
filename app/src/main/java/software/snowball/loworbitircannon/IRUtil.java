package software.snowball.loworbitircannon;

import android.content.Context;
import android.hardware.ConsumerIrManager;

import com.gc.materialdesign.widgets.Dialog;

import java.util.Random;

/**
 * Created by rudyza on 3/18/2016.
 */
public class IRUtil {
    private ConsumerIrManager ir;
    private BrandConst brandConst;
    private String curBrand;
    private int fr;
    private boolean overridePrompt; //for poweroff command (changed in settings eventually)

    //command names for brandConst
    final String[] funcs = {"power", "poweron", "poweroff", "input", "focusp", "focusm", "brightnessp", "brightnessm", "contrastp", "contrastm",
            "setup", "zoomp", "zoomm"};

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
    final int[] NECbrightnessp = {9024, 4512, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 564, 564, 1692, 564,
            564, 564, 564, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 1692, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 564,
            564, 564, 564, 564, 564, 564, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 1692, 564, 40884};
    final int[] NECbrightnessm = {9024, 4512, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 564, 564, 1692, 564,
            564, 564, 564, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 564,
            564, 564, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 40884};
    final int[] NECcontrastp = {}; //raise contrast
    final int[] NECcontrastm = {}; //lower contrast
    final int[] NECsetup = {9024, 4512, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 564,
            564, 564, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 564, 564,
            564, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 40884};
    final int[] NECzoomp = {9024, 4512, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 564,
            564, 564, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 1692, 564, 564, 564, 564, 564,
            564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 1692, 564, 40884}; //zoom towards
    final int[] NECzoomm = {9024, 4512, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 1692, 564, 564, 564, 564, 564, 564, 564, 1692, 564, 564,
            564, 564, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 564, 564, 1692, 564, 564, 564, 1692, 564, 564, 564, 564, 564,
            564, 564, 564, 564, 1692, 564, 564, 564, 1692, 564, 564, 564, 1692, 564, 1692, 564, 1692, 564, 1692, 564, 40884}; //zoom away

    public IRUtil(Context c) {
        ir = (ConsumerIrManager)c.getSystemService(c.CONSUMER_IR_SERVICE);
        brandConst = new BrandConst();
        curBrand = "NEC"; //defaults to NEC, will eventually change to whatever user is prompted with on startup
        overridePrompt = false; //defaults to false
        frTest();
    }

    //misc methods
    public void setCurBrand(String b) {
        this.curBrand = b;
    }
    public String getCurBrand() { return this.curBrand; }
    public void setFr(int fr) {
        this.fr = fr;
    }
    public int getFr() {
        return this.fr;
    }
    public void frTest() {
        fr = brandConst.getFr(curBrand);
    }

    public boolean willWork() {
        //for now, makes sure device has IR transmitter (could potentially have more to it)
        return ir.hasIrEmitter();
    }

    //see String[] funcs for command names and position

    //command functions
    public void power() {
        if (!willWork()) {
            return;
        }

        ir.transmit(fr, brandConst.getCommand(funcs[0], curBrand));;
    }

    public void powerOn() {
        if (!willWork()) {
            return;
        }

        ir.transmit(fr, brandConst.getCommand(funcs[1], curBrand));
    }

    public void powerOff() {
        if (!willWork()) {
            return;
        }

        if (overridePrompt) { //if override prompt is enabled, send command twice, to bypass the "Are you sure?" dialog and automatically turn projector off
            ir.transmit(fr, brandConst.getCommand(funcs[2], curBrand));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ir.transmit(fr, brandConst.getCommand(funcs[2], curBrand));
        } else {
            ir.transmit(fr, brandConst.getCommand(funcs[2], curBrand));
        }
    }

    public void input() {
        if (!willWork()) {
            return;
        }

        ir.transmit(fr, brandConst.getCommand(funcs[3], curBrand));
    }

    public void focusP() {
        if (!willWork()) {
            return;
        }

        ir.transmit(fr, brandConst.getCommand(funcs[4], curBrand));
    }

    public void focusM() {
        if (!willWork()) {
            return;
        }

        ir.transmit(fr, brandConst.getCommand(funcs[5], curBrand));
    }

    public void brightnessP() {
        if (!willWork()) {
            return;
        }

        ir.transmit(fr, brandConst.getCommand(funcs[6], curBrand));;
    }

    public void brightnessM() {
        if (!willWork()) {
            return;
        }

        ir.transmit(fr, brandConst.getCommand(funcs[7], curBrand));;
    }

    public void zoomP() {
        if (!willWork()) {
            return;
        }

        ir.transmit(fr, brandConst.getCommand(funcs[8], curBrand));;
    }

    public void zoomM() {
        if (!willWork()) {
            return;
        }

        ir.transmit(fr, brandConst.getCommand(funcs[9], curBrand));;
    }

    public void rapidMode() {
        if (!ir.hasIrEmitter()) {
            return;
        }

        //creates thread to handle rapid mode
        new Thread(new Runnable() {
            Random rnd = new Random();
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    int t = rnd.nextInt(3);
                    if (t == 0) {
                        //make projector focus repeatedly
                        for (int y = 0; y < 20; y++) {
                            focusP();
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    } else if (t == 1) {
                        //make projector zoom in repeatedly
                        for (int y = 0; y < 20; y++) {
                            zoomP();
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        input();
                    }

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //simulating projector crash by turning off at the end of the rapid mode
                ir.transmit(fr, NECpOff);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ir.transmit(fr, NECpOff);
            }
        }).start();
    }

    public void springMode() {
        if (!ir.hasIrEmitter()) {
            return;
        }

        //spring mode thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++) {
                    //zoom in 5 times
                    for (int y = 0; y < 5; y++) {
                        zoomP();
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //wait a second before zooming out again
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //zoom out 5 times
                    for (int y = 0; y < 5; y++) {
                        zoomM();
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //wait a second before zooming in again
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

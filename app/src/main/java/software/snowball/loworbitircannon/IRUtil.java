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
    private int delayTime;
    private boolean delay;
    private int fr;
    private boolean overridePrompt; //for poweroff command (changed in settings eventually)

    //command names for brandConst
    final String[] funcs = {"power", "poweron", "poweroff", "input", "focusp", "focusm", "brightnessp", "brightnessm", "contrastp", "contrastm",
            "setup", "zoomp", "zoomm", "picmute", "keylock", "select", "up", "down", "left", "right", "volup", "voldown"};

    public IRUtil(Context c) {
        ir = (ConsumerIrManager)c.getSystemService(c.CONSUMER_IR_SERVICE);
        brandConst = new BrandConst();
        curBrand = "SAMSUNG"; //defaults to NEC, will eventually change to whatever user is prompted with on startup
        overridePrompt = false; //defaults to false
        delay = false;
        delayTime = 0;
        frTest();
    }

    //misc methods
    public void setCurBrand(String b) {
        this.curBrand = b;
        frTest();
    }
    public String getCurBrand() { return this.curBrand; }
    public void setFr(int fr) { this.fr = fr; }
    public int getFr() { return this.fr; }
    public void setDelay(boolean delay) { this.delay = delay; }
    public boolean getDelay(){ return this.delay; }
    public void setDelayTime(int delayTime) { this.delayTime = delayTime; }
    public int getDelayTime() { return this.delayTime; }
    public void frTest() { fr = brandConst.getFr(curBrand); }
    public void setOverridePrompt(boolean b) {
        overridePrompt = b;
    }
    public boolean getOverridePrompt() {
        return overridePrompt;
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
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("power", curBrand));;
    }

    public void powerOn() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("poweron", curBrand));
    }

    public void powerOff() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        if (!overridePrompt) { //if override prompt is enabled, send command twice, to bypass the "Are you sure?" dialog and automatically turn projector off
            ir.transmit(fr, brandConst.getCommand("poweroff", curBrand));
            try {
                Thread.sleep(125);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ir.transmit(fr, brandConst.getCommand("poweroff", curBrand));
        } else {
            ir.transmit(fr, brandConst.getCommand("poweroff", curBrand));
        }
    }

    public void input() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("input", curBrand));
    }

    public void focusP() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("focusp", curBrand));
    }

    public void focusM() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("focusm", curBrand));
    }

    public void brightnessP() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("brightnessp", curBrand));;
    }

    public void brightnessM() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("brightnessm", curBrand));;
    }

    public void zoomP() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("zoomp", curBrand));;
    }

    public void zoomM() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("zoomm", curBrand));;
    }

    public void pictureMute() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("picmute", curBrand));
    }

    public void setup() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("setup", curBrand));
    }

    public void keyLock() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("keylock", curBrand));
    }

    public void select() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("select", curBrand));
    }

    public void up() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("up", curBrand));
    }

    public void down() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("down", curBrand));
    }

    public void left() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("left", curBrand));
    }

    public void right() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("right", curBrand));
    }

    public void volUp() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("volup", curBrand));
    }

    public void volDown() {
        if (!willWork()) {
            return;
        }
        if(delay) {
            runDelay();
        }

        ir.transmit(fr, brandConst.getCommand("voldown", curBrand));
    }

    public void rapidMode() {
        if (!ir.hasIrEmitter()) {
            return;
        }
        if(delay) {
            runDelay();
        }
        final boolean tempDelay = delay;
        delay = false;

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
                        //make projector zoom in repeatedly (not working as of 4/5/16, just set to focus in and out)
                        for (int y = 0; y < 20; y++) {
                            focusM();
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        pictureMute();
                    }

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //simulating projector crash by turning off at the end of the rapid mode
                powerOff();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                powerOff();
                delay = tempDelay;
            }
        }).start();
    }

    public void runDelay() {
        //time in milliseconds
        try {
            Thread.sleep(delayTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void springMode() {
        if (!ir.hasIrEmitter()) {
            return;
        }
        if(delay) {
            runDelay();
        }
        final boolean tempDelay = delay;
        delay = false;

        //spring mode thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++) {
                    //zoom in 5 times
                    for (int y = 0; y < 5; y++) {
                        focusP();
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
                        focusM();
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
                delay = tempDelay;
            }
        }).start();
    }
}

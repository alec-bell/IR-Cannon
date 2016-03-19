package software.snowball.loworbitircannon;

import android.content.Context;
import android.hardware.ConsumerIrManager;

import java.util.Random;

/**
 * Created by rudyza on 3/18/2016.
 */
public class IRUtil {
    private ConsumerIrManager ir;
    private int fr;
    private boolean overridePrompt; //for poweroff command (changed in settings eventually)

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

    public IRUtil(Context context) {
        ir = (ConsumerIrManager)context.getSystemService(context.CONSUMER_IR_SERVICE);
        overridePrompt = false; //defaults to false
        frTest();
    }

    //misc methods
    public void setFr(int fr) {
        this.fr = fr;
    }
    public int getFr() {
        return this.fr;
    }
    public void frTest() {
        fr = 37000;

        if (ir.hasIrEmitter()) {
            ConsumerIrManager.CarrierFrequencyRange[] freqs = ir.getCarrierFrequencies();
            for (ConsumerIrManager.CarrierFrequencyRange range : freqs) {
                fr = range.getMaxFrequency();
            }
        }
    }

    public boolean willWork() {
        //for now, makes sure device has IR transmitter (could potentially have more to it)
        return ir.hasIrEmitter();
    }

    //command functions
    public void power() {
        if (!willWork()) return;

        ir.transmit(fr, NECp);
    }

    public void powerOn() {
        if (!willWork()) return;

        ir.transmit(fr, NECpOn);
    }

    public void powerOff() {
        if (!willWork()) return;

        if (overridePrompt) { //if override prompt is enabled, send command twice, to bypass the "Are you sure?" dialog and automatically turn projector off
            ir.transmit(fr, NECpOff);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ir.transmit(fr, NECpOff);
        } else {
            ir.transmit(fr, NECpOff);
        }
    }

    public void input() {
        if (!willWork()) return;

        ir.transmit(fr, NECinput);
    }

    public void focusP() {
        if (!willWork()) return;

        ir.transmit(fr, NECfocusp);
    }

    public void focusM() {
        if (!willWork()) return;

        ir.transmit(fr, NECfocusm);
    }

    public void brightnessP() {
        if (!willWork()) return;

        ir.transmit(fr, NECbrightnessp);
    }

    public void brightnessM() {
        if (!willWork()) return;

        ir.transmit(fr, NECbrightnessm);
    }

    public void zoomP() {
        if (!willWork()) return;

        ir.transmit(fr, NECzoomp);
    }

    public void zoomM() {
        if (!willWork()) return;

        ir.transmit(fr, NECzoomm);
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
                            ir.transmit(fr, NECfocusp);
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    } else if (t == 1) {
                        //make projector zoom in repeatedly
                        for (int y = 0; y < 20; y++) {
                            ir.transmit(fr, NECzoomp);
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        ir.transmit(fr, NECinput);
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
}

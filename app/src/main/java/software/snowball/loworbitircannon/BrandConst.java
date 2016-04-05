package software.snowball.loworbitircannon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zachrudy on 3/21/16.
 * I know this code is super bad, but I'm still working on it
 */
public class BrandConst {

    private List<int[]> NEC;
    private List<int[]> Epson;
    private List<int[]> Samsung;

    //IR codes for NEC
    final String[] funcs = {"power", "poweron", "poweroff", "input", "focusp", "focusm", "brightnessp", "brightnessm", "contrastp", "contrastm",
            "setup", "zoomp", "zoomm"};
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

    //Epson commands
    final int[] Epp = {};
    final int[] EppOn = {};
    final int[] EppOff = {};
    final int[] Epinput = {};
    final int[] Epfocusp = {};
    final int[] Epfocusm = {};
    final int[] Epbrightnessp = {};
    final int[] Epbrightnessm = {};
    final int[] Epcontrastp = {};
    final int[] Epcontrastm = {};
    final int[] Epsetup = {};
    final int[] Epzoomp = {};
    final int[] Epzoomm = {};

    //Samsung commands
    final int[] Samp = {};
    final int[] SamOn = {};
    final int[] SamOff = {};
    final int[] Saminput = {};
    final int[] Samfocusp = {};
    final int[] Samfocusm = {};
    final int[] Sambrightnessp = {};
    final int[] Sambrightnessm = {};
    final int[] Samcontrastp = {};
    final int[] Samcontrastm = {};
    final int[] Samsetup = {};
    final int[] Samzoomp = {};
    final int[] Samzoomm = {};

    //I understand that this is super immature code
    public BrandConst() {
        NEC = new ArrayList<>();
        Epson = new ArrayList<>();
        Samsung = new ArrayList<>();

        NEC.add(NECp);
        NEC.add(NECpOn);
        NEC.add(NECpOff);
        NEC.add(NECinput);
        NEC.add(NECfocusp);
        NEC.add(NECfocusm);
        NEC.add(NECbrightnessp);
        NEC.add(NECbrightnessm);
        NEC.add(NECcontrastp);
        NEC.add(NECcontrastm);
        NEC.add(NECsetup);
        NEC.add(NECzoomp);
        NEC.add(NECzoomm);
        Epson.add(Epp);
        Epson.add(EppOn);
        Epson.add(EppOff);
        Epson.add(Epinput);
        Epson.add(Epfocusp);
        Epson.add(Epfocusm);
        Epson.add(Epbrightnessp);
        Epson.add(Epbrightnessm);
        Epson.add(Epcontrastp);
        Epson.add(Epcontrastm);
        Epson.add(Epsetup);
        Epson.add(Epzoomp);
        Epson.add(Epzoomm);
        Samsung.add(Samp);
        Samsung.add(SamOn);
        Samsung.add(SamOff);
        Samsung.add(Saminput);
        Samsung.add(Samfocusp);
        Samsung.add(Samfocusm);
        Samsung.add(Sambrightnessp);
        Samsung.add(Sambrightnessm);
        Samsung.add(Samcontrastp);
        Samsung.add(Samcontrastm);
        Samsung.add(Samsetup);
        Samsung.add(Samzoomp);
        Samsung.add(Samzoomm);
    }

    public int getFr(String brand) {
        int fr = 0;
        switch (brand) {
            case ("NEC"):
                fr = 38000;
                break;
            case ("EPSON"):
                fr = 38000;
                break;
            case ("SAMSUNG"):
                fr = 38000;
                break;
            default:
                fr = 38000;
                break;
        }

        return fr;
    }

    public int[] getCommand(String command, String brand) {
        //loop through to find command index
        int index = 0;
        for (int i = 0; i < funcs.length; i++) {
            if (command.equalsIgnoreCase(funcs[i])) {
                index = i;
                break;
            }
        }

        int[] ans;
        switch (brand) {
            case "NEC":
                ans = NEC.get(index);
                break;
            case "EPSON":
                ans = Epson.get(index);
                break;
            case "SAMSUNG":
                ans = Samsung.get(index);
                break;
            default:
                ans = new int[0];
                break;
        }

        return ans;
    }
}

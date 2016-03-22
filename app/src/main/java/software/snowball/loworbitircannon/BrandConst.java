package software.snowball.loworbitircannon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zachrudy on 3/21/16.
 */
public class BrandConst {

    private List<String> ids;
    private List<int[]> NEC;
    private List<int[]> Epson;
    private List<int[]> Samsung;

    //IR codes for NEC
    final String[] n = {"power", "poweron", "poweroff", "input", "focusp", "focusm", "brightnessp", "brightnessm", "contrastp", "contrastm",
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

    /**
    **
     * default constructor for brandconst
     * takes no parameters
     * need to figure out better way of putting brand codes into respective const lists
     * will get hard when adding more brands
     *
     **/
    public BrandConst() {
        ids = new ArrayList<>(Arrays.asList(n));
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

    public int[] getPower(String Brand) {
        switch (Brand) {
            case "NEC":
                return NEC.get(0);
            case "Epson":
                return Epson.get(0);
            default:
                return null;
        }
    }

    public int[] getPowerOn(String Brand) {
        switch (Brand) {
            case "NEC":
                return NEC.get(1);
            case "Epson":
                return Epson.get(1);
            default:
                return null;
        }
    }

    public int[] getPowerOff(String Brand) {
        switch (Brand) {
            case "NEC":
                return NEC.get(2);
            case "Epson":
                return Epson.get(2);
            default:
                return null;
        }
    }

    public int[] getInput(String Brand) {
        switch (Brand) {
            case "NEC":
                return NEC.get(3);
            case "Epson":
                return Epson.get(3);
            default:
                return null;
        }
    }

    public int[] getFocusp(String Brand) {
        switch (Brand) {
            case "NEC":
                return NEC.get(4);
            case "Epson":
                return Epson.get(4);
            default:
                return null;
        }
    }

    public int[] getFocusm(String Brand) {
        switch (Brand) {
            case "NEC":
                return NEC.get(5);
            case "Epson":
                return Epson.get(5);
            default:
                return null;
        }
    }
}

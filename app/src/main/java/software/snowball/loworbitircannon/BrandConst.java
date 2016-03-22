package software.snowball.loworbitircannon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zachrudy on 3/21/16.
 */
public class BrandConst {

    private List<String> id;
    private List<int[]> NEC;

    public BrandConst() {
        id = new ArrayList<String>();
        NEC = new ArrayList<int[]>();
    }

    public int[] getPower(String Brand) {
        switch (Brand) {
            case "NEC":
                return NEC.get(0);
            default:
                return null;
        }
    }

    public int[] getPowerOn(String Brand) {
        switch (Brand) {
            case "NEC":
                return NEC.get(1);
            default:
                return null;
        }
    }
}

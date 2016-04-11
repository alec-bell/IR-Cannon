package software.snowball.loworbitircannon;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rudyza on 4/10/2016.
 */
public class CommandQueue implements Runnable {

    private List<String> queue;
    private IRUtil irUtil;

    public CommandQueue(Context context, String brand) {
        queue = new ArrayList<String>();
        irUtil = new IRUtil(context);
    }

    @Override
    public void run() {
        while (queue.size() > 0) {

        }
    }

    public void addCommand(String command) {
        queue.add(command);
    }

    public int getCommandCount() {
        return queue.size();
    }
}

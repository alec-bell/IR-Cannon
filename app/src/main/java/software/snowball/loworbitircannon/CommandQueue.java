package software.snowball.loworbitircannon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rudyza on 4/10/2016.
 */
public class CommandQueue implements Runnable {

    private List<String> queue;

    public CommandQueue() {
        queue = new ArrayList<String>();
    }

    @Override
    public void run() {

    }

    public void addCommand(String command) {
        queue.add(command);
    }

    public int getCommandCount() {
        return queue.size();
    }
}

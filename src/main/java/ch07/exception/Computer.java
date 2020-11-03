package ch07.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Computer {

    Logger LOG = Logger.getLogger(this.toString());
    List<Task> tasks = new ArrayList<>();

    public void addTask(Task t) {
        tasks.add(t);
    }

    public void start() {
        for (Task t : tasks) {
            t.start();
        }
    }

    public boolean isEverythingOk() {
        LOG.info("checking whether everything is OK .... ");
        boolean isOk = true;
        for (Task t : tasks) {
            if (t.getStatus() != ComputeStatus.FINISHED ) {
                isOk = false;
            }
        }

        return isOk;
    }

}

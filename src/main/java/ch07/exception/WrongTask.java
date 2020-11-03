package ch07.exception;

import java.util.concurrent.TimeUnit;

public class WrongTask extends Task {

    public WrongTask() {
        super();
    }

    @Override
    public void advance() {
        try {
            LOG.info("entered advance(): " + getStatus());
            status = ComputeStatus.RUNNING;
            LOG.info("in advance(): " + getStatus());

            TimeUnit.MILLISECONDS.sleep(100);
            status = ComputeStatus.ERROR;
            LOG.info("exiting advance(): " + getStatus());
        } catch (InterruptedException e) {
            status = ComputeStatus.ABORTED;
            e.printStackTrace();
        }

    }
}

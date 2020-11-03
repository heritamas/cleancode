package ch07.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Task {

    static Logger LOG = Logger.getLogger(Task.class.getName());
    static ExecutorService executor = Executors.newFixedThreadPool(10);

    protected ComputeStatus status;

    public Task() {
        status = ComputeStatus.NA;
    }

    public void start() {
        LOG.info("entered start(): " + getStatus());
        status = ComputeStatus.STARTED;
        LOG.info("in start(): " + getStatus());

        executor.submit(this::advance);
    }

    public ComputeStatus getStatus() {
        return status;
    }

    public void advance() {
        try {
            LOG.info("entered advance(): " + getStatus());
            status = ComputeStatus.RUNNING;
            LOG.info("in advance(): " + getStatus());


            TimeUnit.MILLISECONDS.sleep(100);
            status = ComputeStatus.FINISHED;
            LOG.info("exiting advance(): " + getStatus());
        } catch (InterruptedException e) {
            status = ComputeStatus.ABORTED;
            e.printStackTrace();
        }
    }
}

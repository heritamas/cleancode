package ch07.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Computer {
    static ExecutorService executor = Executors.newFixedThreadPool(10);

    Logger LOG = Logger.getLogger(this.toString());
    List<Task> tasks = new ArrayList<>();
    List<Future<?>> futures = new ArrayList<>();

    public void addTask(Task t) {
        tasks.add(t);
    }

    public void start() {
        for (Task t : tasks) {
            t.start();
            futures.add(executor.submit(t::advance));
        }
    }

    public void waitTimeout(long l, TimeUnit milliseconds) throws ExecutionException {
        try {
            // wait for tasks to finish
            executor.awaitTermination(l, milliseconds);

            /*
                Any kind of exception thrown in a task will be wrapped in an ExecutionException here.
                With get(), we make exception "local" to this thread
             */
            for (Future<?> f : futures) {
                f.get();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // in any case, we stop executor service to let program continue with clean state
            executor.shutdown();
        }

    }
}

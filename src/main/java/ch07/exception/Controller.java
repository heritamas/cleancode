package ch07.exception;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Controller {

    public static void main(String[] args)  {
        Computer cp = new Computer();

        // init tasks
        for (int i = 0; i < 5; ++i) {
            cp.addTask(new Task());
        }
        cp.addTask(new WrongTask());

        try {
            cp.start();
            cp.waitTimeout(1000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            Throwable t = e.getCause();
            System.out.println("Original problem was: " + t.getMessage());
        }
    }
}

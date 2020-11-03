package ch07.exception;

import java.util.concurrent.TimeUnit;

public class Controller {

    public static void main(String[] args) throws InterruptedException {
        Computer cp = new Computer();

        for (int i = 0; i < 5; ++i) {
            cp.addTask(new Task());
        }

        cp.addTask(new WrongTask());
        cp.start();

        boolean isEverythingOk = true;
        do {
            isEverythingOk = cp.isEverythingOk();
            TimeUnit.MILLISECONDS.sleep(100);
        } while (isEverythingOk);
    }
}

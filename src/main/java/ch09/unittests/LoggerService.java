package ch09.unittests;

import java.util.logging.Logger;

public class LoggerService implements Service {
    Logger log = Logger.getLogger("LoggerService");

    @Override
    public void doThis() {
        log.info("doing this ...");
    }

    @Override
    public void doThat() {
        log.info("doing that ...");
    }

    @Override
    public void doSomethingWithArgument(days day) {
        log.info("Today is: " + day);
    }

    @Override
    public void doThisAndThat() {
        doThis();
        doThat();
    }
}

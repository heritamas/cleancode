package ch08.boundary.our;

import ch08.boundary.foreign.SuperComplicated3rdParty;

import java.util.logging.Logger;
import java.util.stream.IntStream;

public class OurCode {

    private Logger log = Logger.getLogger(this.getClass().getName());
    private SuperComplicated3rdParty scp = new SuperComplicated3rdParty();
    
    public void doIt() {
        start();
        perform();
        stop();
    }

    private void start() {
        log.info("starting to use scp");
        scp.start();
    }

    private void perform() {
        log.info("using 3rd party lib to do interesting stuff");
        IntStream.range(0, 3).forEach(
                i -> {
                    scp.doInterestingStuff();
                }
        );
    }

    private void stop() {
        log.info("stopping scp");
        scp.stop();
    }
}

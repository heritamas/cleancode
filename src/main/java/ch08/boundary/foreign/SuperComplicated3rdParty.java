package ch08.boundary.foreign;

import java.util.StringJoiner;
import java.util.logging.Logger;

public class SuperComplicated3rdParty {

    private Logger log = Logger.getLogger(this.getClass().getName());
    private State state;
    private Phase phase;


    public SuperComplicated3rdParty(State state, Phase phase) {
        this.state = state;
        this.phase = phase;
    }

    public SuperComplicated3rdParty() {
        this.state = new State();
        this.phase = Phase.BEGIN;
    }

    public void start() {
        phase = Phase.RUN;
        log.info("phase: " + phase);
    }

    public void stop() {
        phase = Phase.FINISH;
        log.info("phase: " + phase);
    }

    public void abort() {
        phase = Phase.ABORT;
        log.info("phase: " + phase);
    }

    public void doInterestingStuff() {
        log.info("doing: " + state.whatAreWeDoing());
        log.info("in phase: " + phase);
    }

    public void doSomethingElse() {
        log.info("doing something else");
    }

    public void soSomethingTotallyDifferent() throws Exception {
        log.info("doing something surprising");
        throw new SurprisingException("whoooo");
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SuperComplicated3rdParty.class.getSimpleName() + "[", "]")
                .add("state=" + state)
                .add("phase=" + phase)
                .toString();
    }
}

package ch08.boundary.foreign;

import java.util.StringJoiner;

public enum Phase {

    BEGIN,
    RUN,
    ABORT,
    FINISH;

    @Override
    public String toString() {
        return new StringJoiner(", ", Phase.class.getSimpleName() + "[", "]")
                .add(this.name())
                .toString();
    }
}

package ch08.boundary.foreign;

import org.apache.commons.lang.RandomStringUtils;

import java.util.logging.Logger;

public class State {

    Logger log = Logger.getLogger(this.getClass().getName());

    public State() {
    }

    public String whatAreWeDoing() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return generatedString;
    }

}

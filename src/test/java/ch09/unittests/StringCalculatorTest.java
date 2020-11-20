package ch09.unittests;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;


class StringCalculatorTest {
    @Test
    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
        assertThrows(RuntimeException.class, () -> StringCalculator.add("1,2,3"));
    }

    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        StringCalculator.add("1,2");
        assertTrue(true);
    }

    @Test
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        assertThrows(RuntimeException.class, () -> StringCalculator.add("1,X"));
    }
}
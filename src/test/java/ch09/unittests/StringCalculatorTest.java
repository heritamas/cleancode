package ch09.unittests;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class StringCalculatorTest {

    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        assertThrows(RuntimeException.class, () -> StringCalculator.add("1,X"));
    }
    
    @Test
    public final void whenAddingMultipleNumbersThenResultIsCorrect() {
        assertEquals(10, StringCalculator.add("2,3,5")); 
    }
    
    @Test
    public final void whenMoreThan2NumbersAreUsedThenNoExceptionIsThrown() {
        assertEquals(6, StringCalculator.add("1,2,3"));
    }
    
    @Test
    public final void whenEmptyStringThenNoExceptionIsThrown() {
        assertEquals(0, StringCalculator.add(""));
    }
    
    @Test
    public final void whenThereIsEmptyNumberThenNoExceptionIsThrown() {
        assertEquals(4, StringCalculator.add("1,,3"));
    }
    
    @Test
    public final void whenSplittingWithNewLineThenNoExceptionIsThrown() {
        assertEquals(9, StringCalculator.add("4\n5"));
    }
    
    @Test
    public final void whenAddingTooBigNumberThenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add(Integer.MAX_VALUE/2 + ",5"));
    }
    
    @Test
    public final void whenAddingUnparseableNumberThenThrowException() {
        assertThrows(NumberFormatException.class, () -> StringCalculator.add(Integer.MAX_VALUE + "0,6"));
    }
    
    @Test
    public final void whenAddNegativeandPositiveNumberThenResultIsCorrect() {
        assertEquals(15, StringCalculator.add("20,-5"));
    }

    @Test
    public final void whenAddTwoNegativeNumbersThenResultIsCorrect() {
        assertEquals(-25, StringCalculator.add("-20,-5"));
    }
    
}
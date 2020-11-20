package ch09.unittests;

public class StringCalculator {

    public static int add(final String numbers) {
        if (numbers.isEmpty() || numbers == null){
            return 0;
        }
        int result = 0;
        String[] numbersArray = numbers.split(",|\n");
        for (String number : numbersArray) {
            if (!number.isEmpty()) {
                int numberInteger = Integer.parseInt(number); // If it is not a number, parseInt will throw an exception
                if (numberInteger >= Integer.MAX_VALUE/2){
                    throw new IllegalArgumentException("Number too big.");
                }
                result = result + numberInteger;
            }
        }
        return result;
    }

}
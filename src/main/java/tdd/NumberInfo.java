package tdd;

public class NumberInfo {

    public static String info(int number) {
        String output = String.valueOf(number);

        if (number % 5 == 0 && number % 3 == 0) {
            output = "Divisible by 3 and 5";
        } else if (number % 5 == 0) {
            output = "Divisible by 5";
        } else if (number % 3 == 0) {
            output = "Divisible by 3";
        }

        return output;
    }
}

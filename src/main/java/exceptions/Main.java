package exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
// # Invalid person data

//        Person p = new Person(null, "Last Name", 13);
//        Person p = new Person("First Name", null, 13);
//        Person p = new Person("      ", "Last Name", 13);
//        Person p = new Person("First Name", "    ", 13);
//        Person p = new Person("First Name", "Last Name", -1);
//        Person p = new Person("First Name", "Last Name", 121);
//        Person p = new Person(null, null, -13);

// # Valid person data

        Person p = new Person("First Name", "Last Name", 13);

        System.out.println(p);

        while (true) {
            String input = scanner.nextLine();

            try {
                int dayAsNumber = Integer.parseInt(input);
                System.out.println("Hello, today is " + getWeekDay(dayAsNumber));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number input, please enter number in between [1...7]");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static String getWeekDay(int dayNumber) {
        return switch (dayNumber) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> throw new IllegalArgumentException("Invalid day of week " + dayNumber
                    + " valid days are in between [1...7]");
        };
    }

    public static void testTryFinally() {
        System.out.println("Code executed before try-finally.");

        try {
            String str = new Scanner(System.in).nextLine();
            Integer.parseInt(str);
            System.out.println("Parsing was successful.");
            return; // Exit from the current method
        } catch (NumberFormatException ex) {
            System.out.println("Parsing failed!");
        } finally {
            System.out.println("Finally block code executed");
        }

        System.out.println("This code is after the try-finally block.");
    }
}

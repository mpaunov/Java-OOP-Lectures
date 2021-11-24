package exceptions;

import java.util.Scanner;
import java.util.stream.IntStream;

public class RangePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            try {
                int start = Integer.parseInt(scanner.nextLine());
                int end = Integer.parseInt(scanner.nextLine());

                printRange(start, end);
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid integers");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void printRange(int start, int end) {
        try {
            validateRange(start, end);
        } catch (InvalidRangeException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }

        IntStream.rangeClosed(start, end)
                .forEach(System.out::println);
    }

    private static void validateRange(int start, int end) throws InvalidRangeException {
        if (start <= 1 || start >= end || end >= 100) {
            throw new InvalidRangeException("The range should be 1 < start < end < 100");
        }
    }
}

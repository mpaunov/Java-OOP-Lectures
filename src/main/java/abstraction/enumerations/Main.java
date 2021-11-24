package abstraction.enumerations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        String season = input[2];
        String discountType = input[3];

        PriceCalculator calculator = new PriceCalculator(
                pricePerDay, numberOfDays, Season.fromString(season), Discount.fromString(discountType));

        System.out.printf("%.2f%n", calculator.calculate());
    }
}

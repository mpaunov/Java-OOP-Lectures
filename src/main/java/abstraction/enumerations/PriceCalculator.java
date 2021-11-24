package abstraction.enumerations;

public class PriceCalculator {
    private double pricePerDay;
    private int days;
    private Season season;
    private Discount discount;

    public PriceCalculator(double pricePerDay, int days, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discount = discount;
    }

    public double calculate() {
        int multiplier = season.getMultiplier();

        double percentDiscount = discount.getPercentage();

        return pricePerDay * days * multiplier * (1 - percentDiscount);
    }
}

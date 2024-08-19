package hotelreservation;

public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private DiscountType discountType;

    public PriceCalculator(double pricePerDay, int numberOfDays,
                           Season season, DiscountType discountType) {

        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }

    public double calculateTotalPrice() {
        double basePrice = pricePerDay * numberOfDays * season.getMultiplier();
        double discount = basePrice * discountType.getDiscountPercentage() / 100;

        return basePrice - discount;
    }

}
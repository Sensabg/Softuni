import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] inputInfo = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(inputInfo[0]);
        int numberOfDays = Integer.parseInt(inputInfo[1]);
        Season season = Season.parseString(inputInfo[2]);
        DiscountType discountType = DiscountType.parseString(inputInfo[3]);

        PriceCalculator calculator = new PriceCalculator(pricePerDay, numberOfDays, season, discountType);
        double totalPrice = calculator.calculateTotalPrice();

        System.out.printf("%.2f", totalPrice);
    }
}
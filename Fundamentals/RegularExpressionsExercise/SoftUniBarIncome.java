package RegularExpressionsExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String regex = "%(?<customerName>[A-Z][a-z]+)%[^\\|$%\\.]*<(?<product>\\w+)>[^\\|\\$%\\.]*\\|(?<amount>[0-9]+)\\|[^\\|\\$%\\.]*?(?<price>[0-9]+\\.?[0-9]*)\\$";
        Pattern pattern = Pattern.compile(regex);
        double totalPrice = 0;

        while (!"end of shift".equals(input = scanner.nextLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String customerName = matcher.group("customerName");
                String product = matcher.group("product");
                int amount = Integer.parseInt(matcher.group("amount"));
                double price = Double.parseDouble(matcher.group("price"));
                 totalPrice += amount * price;

                System.out.printf("%s: %s - %.2f\n",customerName,product,price*amount);
            }
        }
        System.out.printf("Total income: %.2f",totalPrice);
    }
}
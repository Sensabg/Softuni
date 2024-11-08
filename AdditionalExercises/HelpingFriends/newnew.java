import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class newnew {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> productsQuantity = new LinkedHashMap<>();
        Map<String, Double> productsPrice = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("buy")) {

            String productName = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            int quantity = Integer.parseInt(input.split(" ")[2]);

            productsQuantity.merge(productName, quantity, Integer::sum);
            productsPrice.put(productName, price);

            input = scanner.nextLine();
        }

        productsQuantity.forEach((productName, productQuantity) -> {
            double productPrice = productsPrice.get(productName);
            System.out.printf("%s -> %.2f\n", productName, productQuantity * productPrice);
        });
    }
}

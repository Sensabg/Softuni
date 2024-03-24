package FinalExams;

import java.util.*;

public class Problem3BakeryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> stocks = new LinkedHashMap<>();
        String input;
        int sum = 0;

        while (!"Complete".equals(input = scanner.nextLine())) {
            String[] info = input.split(" ");
            String command = info[0];
            int quantity = Integer.parseInt(info[1]);
            String food = info[2];
            int currentQuantity;

            switch (command) {

                case "Receive":
                    if (quantity > 0) {
                        if (!stocks.containsKey(food)) {
                            stocks.put(food, quantity);
                        } else {
                            currentQuantity = stocks.get(food);
                            stocks.put(food,currentQuantity + quantity);
                        }
                    }
                    break;

                case "Sell":
                    if (!stocks.containsKey(food)) {
                        System.out.printf("You do not have any %s.\n", food);
                    } else {
                        currentQuantity = stocks.get(food);
                        if (quantity > currentQuantity) {
                            sum += currentQuantity;
                            System.out.printf("There aren't enough %s. You sold the last %d of them.\n", food, currentQuantity);
                            stocks.remove(food);
                        } else {
                            sum += quantity;
                            System.out.printf("You sold %d %s.\n", quantity, food);
                            stocks.put(food, currentQuantity - quantity);
                            if (currentQuantity - quantity <= 0) {
                                stocks.remove(food);
                            }
                        }
                    }
                    break;
            }
        }
        for (Map.Entry<String, Integer> inStock : stocks.entrySet()) {
            String stock = inStock.getKey();
            int amount = inStock.getValue();
            System.out.println(stock + ": " + amount);
        }
        System.out.printf("All sold: %d goods", sum);
    }
}
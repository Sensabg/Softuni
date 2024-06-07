package ExamPrep.Exam2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class T01ChickenSnack1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> moneyList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));

        List<Integer> priceList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int countMeals = 0;
        while (!moneyList.isEmpty() && !priceList.isEmpty()) {
            int currentMoney = moneyList.remove(moneyList.size() - 1);
            int currentPrice = priceList.remove(0);

            if (currentMoney == currentPrice) {
                countMeals++;
            } else if (currentMoney > currentPrice) {
                countMeals++;
                int change = currentMoney - currentPrice;
                if (!moneyList.isEmpty()) {
                    moneyList.set(moneyList.size() - 1, moneyList.get(moneyList.size() - 1) + change);
                }
            }
        }
        if (countMeals >= 4) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.%n", countMeals);
        } else if (countMeals > 1) {
            System.out.printf("Henry ate: %d foods.%n", countMeals);
        } else if (countMeals == 1) {
            System.out.printf("Henry ate: %d food.%n", countMeals);
        } else {
            System.out.println("Henry remained hungry. He will try next weekend again.");
        }
    }
}
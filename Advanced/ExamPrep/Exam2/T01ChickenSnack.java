package ExamPrep.Exam2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T01ChickenSnack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> currentBudgetStack = new ArrayDeque<>();
        for (String cash : scanner.nextLine().split("\\s+")) {
            currentBudgetStack.push(Integer.parseInt(cash));
        }

        ArrayDeque<Integer> priceQueue = new ArrayDeque<>();
        for (String price : scanner.nextLine().split("\\s+")) {
            priceQueue.offer(Integer.parseInt(price));
        }

        int countMeals = 0;
        while (!currentBudgetStack.isEmpty() && !priceQueue.isEmpty()) {
            int currentCash = currentBudgetStack.pop();
            int currentPrice = priceQueue.poll();

            if (currentCash > currentPrice) {
                countMeals++;
                int diff = currentCash - currentPrice;
                if (!currentBudgetStack.isEmpty()) {
                    currentBudgetStack.push(currentBudgetStack.pop() + diff);
                }
            } else if (currentCash == currentPrice) {
                countMeals++;
            }
        }

        if (countMeals == 0) {
            System.out.println("Henry remained hungry. He will try next weekend again.");
        } else if (countMeals == 1) {
            System.out.printf("Henry ate: %d food.%n", countMeals);
        } else if (countMeals > 1 && countMeals < 4) {
            System.out.printf("Henry ate: %d foods.%n", countMeals);
        } else if (countMeals >= 4) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.%n", countMeals);
        }
    }
}

package PBexamTwo;

import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int walkPerDay = Integer.parseInt(scanner.nextLine());
        int walksAmount = Integer.parseInt(scanner.nextLine());
        int caloriesPerDay = Integer.parseInt(scanner.nextLine());

        int totalWalk = walksAmount * walkPerDay;
        int calories = totalWalk * 5;

        int requiredCalories = caloriesPerDay / 2;

        if (calories >= requiredCalories) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", calories);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", calories);
        }
    }
}

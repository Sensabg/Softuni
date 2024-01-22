package PBexamTwo;

import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amountDays = Integer.parseInt(scanner.nextLine());
        double totalFood = Double.parseDouble(scanner.nextLine());

        double dogFoodEaten = 0;
        double catFoodEaten = 0;
        double totalFoodEaten = 0;
        double biscuits = 0;

        for (int i = 1; i <= amountDays; i++) {
            int dogFood = Integer.parseInt(scanner.nextLine());
            int catFood = Integer.parseInt(scanner.nextLine());

            dogFoodEaten += dogFood;
            catFoodEaten += catFood;

            if(i % 3 ==0){
                biscuits += (dogFood + catFood) * 0.10;
            }
        }

        totalFoodEaten = (dogFoodEaten + catFoodEaten) / totalFood;

        System.out.printf("Total eaten biscuits: %.0fgr.",biscuits);
        System.out.printf("\n%.2f%% of the food has been eaten.",totalFoodEaten * 100);
        System.out.printf("\n%.2f%% eaten from the dog.",(dogFoodEaten / (dogFoodEaten + catFoodEaten)) * 100);
        System.out.printf("\n%.2f%% eaten from the cat.",(catFoodEaten / (dogFoodEaten + catFoodEaten)) * 100);

    }
}
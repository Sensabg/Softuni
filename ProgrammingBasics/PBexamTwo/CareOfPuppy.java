package PBexamTwo;

import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int foodBoughtKg = Integer.parseInt(scanner.nextLine());
        int foodBoughG = foodBoughtKg * 1000;

        int totalFood = 0;

        String command = scanner.nextLine();
        while (!"Adopted".equals(command)) {
            int amountOfFood = Integer.parseInt(command);
            totalFood += amountOfFood;


            command = scanner.nextLine();
        }

        if (foodBoughG >= totalFood){
            System.out.printf("Food is enough! Leftovers: %d grams.",foodBoughG - totalFood);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.",Math.abs(foodBoughG - totalFood));
        }

    }
}

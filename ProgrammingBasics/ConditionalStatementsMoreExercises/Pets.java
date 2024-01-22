package ConditionalStatementsMoreExercises;

import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int foodLeft = Integer.parseInt(scanner.nextLine());
        double foodDog = Double.parseDouble(scanner.nextLine());
        double foodCat = Double.parseDouble(scanner.nextLine());
        double foodTurtle = Double.parseDouble(scanner.nextLine());

        double foodNeededDog = days * foodDog;
        double foodNeededCat = days * foodCat;
        double foodNeededTurtle = days * (foodTurtle / 1000);

        double totalFood = foodNeededDog + foodNeededCat + foodNeededTurtle;
        double foodDiff = Math.abs(foodLeft - totalFood);

        if(foodLeft > totalFood){
            System.out.printf("%.0f kilos of food left.", Math.floor(foodDiff));
        } else {
            System.out.printf("%.0f more kilos of food are needed.",Math.ceil(foodDiff));
        }
    }
}

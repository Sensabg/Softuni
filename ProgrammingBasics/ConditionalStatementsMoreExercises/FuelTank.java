package ConditionalStatementsMoreExercises;

import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String Fuel = scanner.nextLine();
        int fuel = Integer.parseInt(scanner.nextLine());

        String One = "Diesel";
        String Two = "Gasoline";
        String Three = "Gas";

        String modifiedFuel = Character.toLowerCase(Fuel.charAt(0)) + Fuel.substring(1);

        if (!One.equals(Fuel) && !Two.equals(Fuel) && !Three.equals(Fuel)){
            System.out.println("Invalid fuel!");
        } else if (fuel >= 25) {
            System.out.printf("You have enough %s.", modifiedFuel);
        } else if (fuel < 25) {
            System.out.printf("Fill your tank with %s!", modifiedFuel);
        }

    }
}

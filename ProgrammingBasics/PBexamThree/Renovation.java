package PBexamThree;

import java.util.Scanner;

public class Renovation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int unpaintedPercentage = Integer.parseInt(scanner.nextLine());

        boolean goalReached = false;

        int surface = height * width * 4;
        double totalSurface = Math.ceil(surface - (surface * (unpaintedPercentage * 0.01)));

        String command = scanner.nextLine();
        while (!command.equals("Tired!")) {
            int amountOfPaint = Integer.parseInt(command);

            totalSurface -= amountOfPaint;

            if (totalSurface <= 0) {
                goalReached = true;
                break;
            }

            command = scanner.nextLine();
        }

        if (!goalReached) {
            System.out.printf("%.0f quadratic m left.",totalSurface );
        } else if (goalReached && totalSurface == 0 ){
            System.out.println("All walls are painted! Great job, Pesho!");
        } else {
            System.out.printf("All walls are painted and you have %.0f l paint left!",Math.abs(totalSurface));
        }
    }
}

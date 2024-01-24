package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int totalCapacity = 255;
        int total = 0;

        for (int i = 1; i <= n; i++) {
            int numbers = Integer.parseInt(scanner.nextLine());

            if (totalCapacity - total < numbers) {
                System.out.print("Insufficient capacity!\n");
                continue;
            }
            if (totalCapacity - total >= numbers) {
                total += numbers;
            }
        }
        System.out.println(total);
    }
}


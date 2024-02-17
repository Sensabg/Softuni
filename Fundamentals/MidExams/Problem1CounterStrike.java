package MidExams;

import java.util.Scanner;

public class Problem1CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int countRounds = 0;

        String command = scanner.nextLine();
        while (!"End of battle".equals(command)) {
            int distance = Integer.parseInt(command);

            if (energy - distance < 0) {
                System.out.print("Not enough energy! ");
                System.out.print("Game ends with " + countRounds + " won battles and " + energy + " energy");
                return;
            }
            countRounds++;

            energy -= distance;

            if (countRounds % 3 == 0) {
                energy += countRounds;
            }
            command = scanner.nextLine();
        }
        System.out.print("Won battles: " + countRounds + ". ");
        System.out.print("Energy left: " + energy);
    }
}
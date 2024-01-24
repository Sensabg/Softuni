package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBug {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());

        int[] ladybugsPosition = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] field = new int[fieldSize];
        Arrays.stream(ladybugsPosition).forEach(position -> field[position] = 1);

        String command = scanner.nextLine();
        while (!"end".equals(command)) {
            String[] tokens = command.split(" ");
            int ladybugIndex = Integer.parseInt(tokens[0]);
            String direction = tokens[1];
            int flyLength = Integer.parseInt(tokens[2]);

            if (ladybugIndex >= 0 && ladybugIndex < fieldSize && field[ladybugIndex] == 1) {
                field[ladybugIndex] = 0;
                int newPosition;

                if (direction.equals("right")) {
                    newPosition = ladybugIndex + flyLength;
                } else {
                    newPosition = ladybugIndex - flyLength;
                }
                while (newPosition >= 0 && newPosition < fieldSize && field[newPosition] == 1) {
                    if (direction.equals("right")) {
                        newPosition += flyLength;
                    } else {
                        newPosition -= flyLength;
                    }
                }
                if (newPosition >= 0 && newPosition < fieldSize) {
                    field[newPosition] = 1;
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(Arrays.toString(field).replaceAll("[\\[\\],]", ""));
    }
}
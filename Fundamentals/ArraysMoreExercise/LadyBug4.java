package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBug4 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int fieldSize = Integer.parseInt(scanner.nextLine());
            int[] ladybugsPosition = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] field = new int[fieldSize];
            Arrays.stream(ladybugsPosition).forEach(position -> field[position] = 1);

            String command;
            while (!"end".equals(command = scanner.nextLine())) {
                int ladybugIndex = Integer.parseInt(command.split(" ")[0]);
                String direction = command.split(" ")[1];
                int flyLength = Integer.parseInt(command.split(" ")[2]);

                if (isValidIndex(ladybugIndex, fieldSize) && field[ladybugIndex] == 1) {
                    field[ladybugIndex] = 0;
                    int newPosition = getNewPosition(ladybugIndex, flyLength, direction, fieldSize);

                    while (isValidIndex(newPosition, fieldSize) && field[newPosition] == 1) {
                        newPosition = getNewPosition(newPosition, flyLength, direction, fieldSize);
                    }
                    if (isValidIndex(newPosition, fieldSize)) {
                        field[newPosition] = 1;
                    }
                }
            }
            System.out.println(Arrays.toString(field).replaceAll("[\\[\\],]", ""));
        }
        private static boolean isValidIndex(int index, int fieldSize) {
            return index >= 0 && index < fieldSize;
        }
        private static int getNewPosition(int currentPosition, int flyLength, String direction, int fieldSize) {
            return direction.equals("right") ? currentPosition + flyLength : currentPosition - flyLength;
        }
    }
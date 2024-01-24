package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBug2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] ladybugsPosition = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] field = new int[fieldSize];
        Arrays.fill(field, 0);
        Arrays.stream(ladybugsPosition).forEach(position -> field[position] = 1);

        String command = scanner.nextLine();
        while (!"end".equals(command)) {

            String[] tokens = command.split(" ");

            int ladybugIndex = Integer.parseInt(tokens[0]);
            String direction = tokens[1];
            int flyLength = Integer.parseInt(tokens[2]);

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
            command = scanner.nextLine();
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
package ListsExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command;
        while (!(command = scanner.nextLine()).equals("End")) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];

            switch (action) {
                case "Add":
                    numbers.add(Integer.parseInt(tokens[1]));
                    break;
                case "Insert":
                    int insertIndex = Integer.parseInt(tokens[2]);
                    performSafeOperation(() -> numbers.add(insertIndex, Integer.parseInt(tokens[1])));
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(tokens[1]);
                    performSafeOperation(() -> numbers.remove(removeIndex));
                    break;
                case "Shift":
                    String shiftDirection = tokens[1];
                    int count = Integer.parseInt(tokens[2]);
                    performSafeOperation(() -> shift(numbers, shiftDirection, count));
                    break;
            }
        }

        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static void shift(List<Integer> numbers, String direction, int count) {
        int size = numbers.size();
        count = (count % size + size) % size; // Handling negative count
        Collections.rotate(numbers, direction.equals("right") ? count : -count);
    }

    private static void performSafeOperation(Runnable operation) {
        try {
            operation.run();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index");
        }
    }
}
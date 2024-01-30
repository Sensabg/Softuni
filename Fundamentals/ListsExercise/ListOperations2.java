package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];

            switch (action) {
                case "Add":
                    numbers.add(Integer.parseInt(tokens[1]));
                    break;
                case "Insert":
                    int insertIndex = Integer.parseInt(tokens[2]);
                    if (isValid(insertIndex, numbers)) {
                        numbers.add(insertIndex, Integer.parseInt(tokens[1]));
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(tokens[1]);
                    if (isValid(removeIndex, numbers)) {
                        numbers.remove(removeIndex);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String shiftDirection = tokens[1];
                    int count = Integer.parseInt(tokens[2]);
                    shift(numbers, shiftDirection, count);
                    break;
            }
            command = scanner.nextLine();
        }
        printNumbers(numbers);
    }

    private static void shift(List<Integer> numbers, String direction, int count) {
        int size = numbers.size();
        count %= size;
        if (count < 0) {
            count += size;
        }

        if (direction.equals("right")) {
            while (count-- > 0) {
                numbers.add(0, numbers.remove(size - 1));
            }
        } else {
            while (count-- > 0) {
                numbers.add(numbers.remove(0));
            }
        }
    }

    private static void printNumbers(List<Integer> numbers) {
        System.out.println(numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static boolean isValid(int index, List<Integer> numbers) {
        return index >= 0 && index < numbers.size();
    }
}


package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];

            switch (action) {
                case "Add":
                    int addNumber = Integer.parseInt(tokens[1]);
                    numbers.add(addNumber);
                    break;
                case "Insert":
                    int insertNumber = Integer.parseInt(tokens[1]);
                    int insertIndex = Integer.parseInt(tokens[2]);
                    if (isValid(insertIndex, numbers)) {
                        numbers.add(insertIndex, insertNumber);
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
                    int move = Integer.parseInt(tokens[2]);
                    if (shiftDirection.equals("right")) {
                        moveRight(move, numbers);
                    } else {
                        moveLeft(move, numbers);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        printNumbers(numbers);
    }

    private static void printNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    private static void moveLeft(int move, List<Integer> numbers) {
        for (int i = 0; i < move; i++) {
            int firstElement = numbers.remove(0);
            numbers.add(firstElement);
        }
    }

    private static void moveRight(int move, List<Integer> numbers) {
        for (int i = 0; i < move; i++) {
            int lastElement = numbers.remove(numbers.size() - 1);
            numbers.add(0, lastElement);
        }
    }

    private static boolean isValid(int index, List<Integer> numbers) {
        return index >= 0 && index < numbers.size();
    }
}
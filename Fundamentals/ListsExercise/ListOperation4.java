package ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListOperation4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(numbers::add);

        String command;
        while (!(command = scanner.nextLine()).equals("End")) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];

            switch (action) {
                case "Add":
                    addElement(numbers, Integer.parseInt(tokens[1]));
                    break;
                case "Insert":
                    insertElement(numbers, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Remove":
                    removeElement(numbers, Integer.parseInt(tokens[1]));
                    break;
                case "Shift":
                    shiftElements(numbers, tokens[1], Integer.parseInt(tokens[2]));
                    break;
            }
        }

        printNumbers(numbers);
    }

    private static void addElement(List<Integer> numbers, int value) {
        numbers.add(value);
    }

    private static void insertElement(List<Integer> numbers, int value, int index) {
        if (isValidIndex(index, numbers.size())) {
            numbers.add(index, value);
        } else {
            System.out.println("Invalid index");
        }
    }

    private static void removeElement(List<Integer> numbers, int index) {
        if (isValidIndex(index, numbers.size())) {
            numbers.remove(index);
        } else {
            System.out.println("Invalid index");
        }
    }

    private static void shiftElements(List<Integer> numbers, String direction, int count) {
        int size = numbers.size();
        count %= size; // Handling negative count

        if (direction.equals("right")) {
            shiftRight(numbers, count);
        } else {
            shiftLeft(numbers, count);
        }
    }

    private static void shiftRight(List<Integer> numbers, int count) {
        while (count-- > 0) {
            numbers.add(0, numbers.remove(numbers.size() - 1));
        }
    }

    private static void shiftLeft(List<Integer> numbers, int count) {
        while (count-- > 0) {
            numbers.add(numbers.remove(0));
        }
    }

    private static void printNumbers(List<Integer> numbers) {
        numbers.forEach(number -> System.out.print(number + " "));
    }

    private static boolean isValidIndex(int index, int size) {
        return index >= 0 && index <= size;
    }
}
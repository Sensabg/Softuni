package MethodsMoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        while (!input.equals("end")) {

            switch (input.split("\\s+")[0]) {
                case "exchange":
                    splitArrayAtGivenIndex(numbers, input);
                    break;
                case "max":
                    if (getMaxIndexOfEvenOrOddNumber(numbers, input) == -1) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(getMaxIndexOfEvenOrOddNumber(numbers, input));
                    }
                    break;
                case "min":
                    if (getMinIndexOfEvenOrOddNumbers(numbers, input) == -1) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(getMinIndexOfEvenOrOddNumbers(numbers, input));
                    }
                    break;
                case "first":
                    if (isInRange(numbers, input)) {
                        printArray(getFirstMaxOrMinNumbers(numbers, input));
                    } else {
                        System.out.println("Invalid count");
                    }
                    break;
                case "last":
                    if (isInRange(numbers, input)) {
                        printArray(getLastMaxOrMinNumbers(numbers, input));
                    } else {
                        System.out.println("Invalid count");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(numbers));
    }

    private static void printArray(int[] numbers) {
        System.out.print("[");

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == -1) {
                continue;
            }
            if (i == numbers.length - 1) {
                System.out.print(numbers[i]);
            } else if (numbers[i + 1] != -1) {
                System.out.print(numbers[i] + ", ");
            } else {
                System.out.print(numbers[i]);
            }
        }
        System.out.println("]");
    }

    private static void splitArrayAtGivenIndex(int[] numbers, String input) {
        int index = Integer.parseInt(input.split("\\s+")[1]);
        if (index < 0 || index >= numbers.length) {
            System.out.println("Invalid index");
            return;
        }
        int[] firstArray = new int[index + 1];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = numbers[i];
        }

        int[] secondArray = new int[numbers.length - index - 1];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = numbers[i + index + 1];
        }

        for (int i = 0; i < secondArray.length; i++) {
            numbers[i] = secondArray[i];
        }

        for (int i = 0; i < firstArray.length; i++) {
            numbers[i + secondArray.length] = firstArray[i];
        }
    }

    private static int getMaxIndexOfEvenOrOddNumber(int[] numbers, String input) {
        String evenOrOdd = input.split("\\s+")[1];
        int bestEvenIndex = -1;
        int bestOddIndex = -1;
        int bestEvenNumber = Integer.MIN_VALUE;
        int bestOddNumber = Integer.MIN_VALUE;

        if (evenOrOdd.equals("even")) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0 && bestEvenNumber <= numbers[i]) {
                    bestEvenIndex = i;
                    bestEvenNumber = numbers[i];
                }
            }
            return bestEvenIndex;
        } else if (evenOrOdd.equals("odd")) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 != 0 && bestOddNumber <= numbers[i]) {
                    bestOddIndex = i;
                    bestOddNumber = numbers[i];
                }
            }
            return bestOddIndex;
        }
        return -1;
    }

    private static int getMinIndexOfEvenOrOddNumbers(int[] numbers, String input) {
        String evenOrOdd = input.split("\\s+")[1];
        int bestEvenIndex = -1;
        int bestOddIndex = -1;
        int bestEvenNumber = Integer.MAX_VALUE;
        int bestOddNumber = Integer.MAX_VALUE;

        if (evenOrOdd.equals("even")) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0 && numbers[i] <= bestEvenNumber) {
                    bestEvenIndex = i;
                    bestEvenNumber = numbers[i];
                }
            }
            return bestEvenIndex;
        } else if (evenOrOdd.equals("odd")) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 != 0 && numbers[i] <= bestOddNumber) {
                    bestOddIndex = i;
                    bestOddNumber = numbers[i];
                }
            }
            return bestOddIndex;
        }
        return -1;
    }

    private static int[] getFirstMaxOrMinNumbers(int[] numbers, String input) {
        int maxCounter = Integer.parseInt(input.split("\\s+")[1]);
        int counter = 0;

        int[] maxArray = new int[maxCounter];
        Arrays.fill(maxArray, -1);

        if (input.split("\\s+")[2].equals("even")) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0 && counter != maxCounter) {
                    maxArray[counter] = numbers[i];
                    counter++;
                }
            }
        } else if (input.split("\\s+")[2].equals("odd")) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 != 0 && counter != maxCounter) {
                    maxArray[counter] = numbers[i];
                    counter++;
                }
            }
        }
        return maxArray;
    }

    private static int[] getLastMaxOrMinNumbers(int[] numbers, String input) {
        int maxCounter = Integer.parseInt(input.split("\\s+")[1]);
        int counter = 0;

        int[] maxArray = new int[maxCounter];
        Arrays.fill(maxArray, -1);

        if (input.split("\\s+")[2].equals("even")) {
            for (int i = numbers.length - 1; i >= 0; i--) {
                if (numbers[i] % 2 == 0 && counter != maxCounter) {
                    maxArray[counter] = numbers[i];
                    counter++;
                }
            }
        } else if (input.split("\\s+")[2].equals("odd")) {
            for (int i = numbers.length - 1; i >= 0; i--) {
                if (numbers[i] % 2 != 0 && counter != maxCounter) {
                    maxArray[counter] = numbers[i];
                    counter++;
                }
            }
        }
        int[] reverse = new int[maxArray.length];
        counter = 0;

        for (int i = maxArray.length - 1; i >= 0; i--) {
            reverse[counter] = maxArray[i];
            counter++;
        }
        return reverse;
    }
    private static boolean isInRange(int[] numbers, String input) {
        int index = Integer.parseInt(input.split("\\s+")[1]);
        return index >= 0 && index <= numbers.length;
    }
}
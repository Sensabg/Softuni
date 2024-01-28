package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().replaceAll("\\p{Zs}", " ").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        System.out.println();
        while (!command.equals("end")) {
            String[] possibilities = command.split(" ");
            switch (possibilities[0]) {
                case "Contains":
                    contains(possibilities, numbers);
                    break;
                case "Print":
                    isEvenOrOdd(possibilities, numbers);
                    break;
                case "Get":
                    getSum(numbers);
                    break;
                case "Filter":
                    returnCondition(possibilities,numbers);
                    break;
            }
            command = scanner.nextLine();
        }
    }

    private static void contains(String[] possibilities, List<Integer> numbers) {
        int number = Integer.parseInt(possibilities[1]);
        boolean isFound = false;
        for (Integer value : numbers) {
            if (value == number) {
                isFound = true;
                break;
            }
        }
        if (isFound) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }
    private static void isEvenOrOdd(String[] possibilities, List<Integer> numbers) {
        if (possibilities[1].equals("even")) {
            printEvenNumbers(numbers);
        } else {
            printOddNumbers(numbers);
        }
    }
    private static void printEvenNumbers(List<Integer> numbers) {
        for (Integer integer : numbers) {
            if (integer % 2 == 0) {
                System.out.print(integer + " ");
            }
        }
        System.out.println();
    }

    private static void printOddNumbers(List<Integer> numbers) {
        for (Integer integer : numbers) {
            if (integer % 2 != 0) {
                System.out.print(integer + " ");
            }
        }
        System.out.println();
    }

    private static void getSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer integer : numbers) {
            sum += integer;
        }
        System.out.println(sum);
    }

    private static void filterBiggerNumbers(List<Integer> numbers, int filter) {
        for (Integer integer : numbers) {
            if (integer > filter) {
                System.out.print(integer + " ");
            }
        }
        System.out.println();
    }

    private static void filterLowerNumbers(List<Integer> numbers, int filter) {
        for (Integer integer : numbers) {
            if (integer < filter) {
                System.out.print(integer + " ");
            }
        }
        System.out.println();
    }

    private static void filterBiggerOrEqualNumbers(List<Integer> numbers, int filter) {
        for (Integer integer : numbers) {
            if (integer >= filter) {
                System.out.print(integer + " ");
            }
        }
        System.out.println();
    }

    private static void filterLowerOrEqualNumbers(List<Integer> numbers, int filter) {
        for (Integer integer : numbers) {
            if (integer <= filter) {
                System.out.print(integer + " ");
            }
        }
        System.out.println();
    }
    private static void returnCondition(String[] possibilities, List<Integer> numbers) {
        int filter = Integer.parseInt(possibilities[2]);
        if (possibilities[1].equals(">")) {
            filterBiggerNumbers(numbers, filter);
        } else if (possibilities[1].equals("<")) {
            filterLowerNumbers(numbers, filter);
        } else if (possibilities[1].equals(">=")) {
            filterBiggerOrEqualNumbers(numbers, filter);
        } else if (possibilities[1].equals("<=")) {
            filterLowerOrEqualNumbers(numbers, filter);
        }
    }
}
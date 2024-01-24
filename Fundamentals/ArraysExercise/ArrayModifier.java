package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            if (command.contains("swap")) {
                int indexOne = Integer.parseInt(command.split(" ")[1]);
                int indexTwo = Integer.parseInt(command.split(" ")[2]);

                int numberOne = numbers[indexOne];
                int numberTwo = numbers[indexTwo];

                numbers[indexOne] = numberTwo;
                numbers[indexTwo] = numberOne;

            } else if (command.contains("multiply")) {
                int indexOne = Integer.parseInt(command.split(" ")[1]);
                int indexTwo = Integer.parseInt(command.split(" ")[2]);

                int numberOne = numbers[indexOne];
                int numberTwo = numbers[indexTwo];

                int replace = numberOne * numberTwo;

                numbers[indexOne] = replace;

            } else if (command.contains("decrease")) {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i]--;
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(Arrays.toString(numbers).
                replace("[", "")
                .replace("]", ""));
    }
}
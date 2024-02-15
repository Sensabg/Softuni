package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem2ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfIntegers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!"end".equals(command)) {

            switch (command.split(" ")[0]) {
                case "swap":
                    int firstIndex = Integer.parseInt(command.split(" ")[1]);
                    int secondIndex = Integer.parseInt(command.split(" ")[2]);
                    int first = listOfIntegers.get(firstIndex);
                    int second = listOfIntegers.get(secondIndex);

                    listOfIntegers.set(firstIndex, second);
                    listOfIntegers.set(secondIndex, first);
                    break;

                case "multiply":
                    int numberAtIndexOne = Integer.parseInt(command.split(" ")[1]);
                    int numberAtIndexTwo = Integer.parseInt(command.split(" ")[2]);
                    int firstNumber = listOfIntegers.get(numberAtIndexOne);
                    int secondNumber = listOfIntegers.get(numberAtIndexTwo);

                    listOfIntegers.set(numberAtIndexOne, firstNumber * secondNumber);
                    break;

                case "decrease":
                    listOfIntegers.replaceAll(n -> n - 1);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.print(listOfIntegers.toString()
                .replace("[", "")
                .replace("]", ""));
    }
}
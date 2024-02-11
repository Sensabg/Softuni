package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem3MemoryGame_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listOfNumbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        int countRounds = 0;

        String command = scanner.nextLine();
        while (!"end".equals(command)) {
            int indexOne = Integer.parseInt(command.split(" ")[0]);
            int indexTwo = Integer.parseInt(command.split(" ")[1]);

            countRounds++;

            if (indexOne == indexTwo
                    || indexOne < 0
                    || indexTwo < 0
                    || indexOne > listOfNumbers.size() - 1
                    || indexTwo > listOfNumbers.size() - 1) {

                listOfNumbers.add(listOfNumbers.size() / 2, "-" + countRounds + "a");
                listOfNumbers.add(listOfNumbers.size() / 2, "-" + countRounds + "a");

                System.out.println("Invalid input! Adding additional elements to the board");
            } else if (listOfNumbers.get(indexOne).equals(listOfNumbers.get(indexTwo))) {

                System.out.printf("Congrats! You have found matching elements - %s!\n", listOfNumbers.get(indexOne));

                String elementOne = listOfNumbers.get(indexOne);
                String elementTwo = listOfNumbers.get(indexTwo);

                List<String> elementsToRemove = List.of(elementOne, elementTwo);
                listOfNumbers.removeAll(elementsToRemove);

            } else {
                System.out.println("Try again!");
            }

            if (listOfNumbers.isEmpty()) {
                System.out.printf("You have won in %d turns!", countRounds);
                return;
            }
            command = scanner.nextLine();
        }
        System.out.println("Sorry you lose :(");
        System.out.println(String.join(" ", listOfNumbers));
    }
}

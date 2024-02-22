package ListsMoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        double timePlayerOne = 0;
        double timePlayerTwo = 0;

        for (int i = 0; i < numbers.size() / 2 ; i++) {
            timePlayerOne += numbers.get(i);
            if (numbers.get(i) == 0) {
                timePlayerOne -= timePlayerOne * 0.20;
            }
        }

        for (int i = numbers.size() - 1; i > numbers.size() / 2 ; i--) {
            timePlayerTwo += numbers.get(i);
            if (numbers.get(i) == 0) {
                timePlayerTwo -= timePlayerTwo * 0.20;
            }
        }

        if (timePlayerOne < timePlayerTwo) {
            System.out.printf("The winner is left with total time: %.1f",timePlayerOne);
        } else {
            System.out.printf("The winner is right with total time: %.1f",timePlayerTwo);
        }
    }
}

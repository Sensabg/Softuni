package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> playerOne = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> playerTwo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!playerOne.isEmpty() && !playerTwo.isEmpty()) {

            if (playerOne.get(0) > playerTwo.get(0)) {
                playerOne.add(playerOne.get(0));
                playerOne.add(playerTwo.get(0));
                playerOne.remove(playerOne.get(0));
                playerTwo.remove(playerTwo.get(0));
            } else if (playerOne.get(0) < playerTwo.get(0)) {
                playerTwo.add(playerTwo.get(0));
                playerTwo.add(playerOne.get(0));
                playerOne.remove(playerOne.get(0));
                playerTwo.remove(playerTwo.get(0));
            } else {
                playerOne.remove(playerOne.get(0));
                playerTwo.remove(playerTwo.get(0));
            }
        }
        if (playerOne.isEmpty()) {
            System.out.printf("Second player wins! Sum: %d", playerTwo.stream().mapToInt(Integer::intValue).sum());
        } else {
            System.out.printf("First player wins! Sum: %d",playerOne.stream().mapToInt(Integer::intValue).sum());
        }
    }
}
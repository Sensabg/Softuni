package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> specialBombNumber = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        int bombNumber = specialBombNumber.get(0);
        int bombPower = specialBombNumber.get(1);

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bombNumber) {
                int leftBound = Math.max(0, i - bombPower);
                int rightBound = Math.min(numbers.size() - 1, i + bombPower);

                numbers.subList(leftBound, rightBound + 1).clear();

                i = Math.max(-1, i - bombPower);
            }
        }
        System.out.println(numbers.stream().mapToInt(Integer::intValue).sum());
    }
}
package ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class BombNumbers2 {
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

        while (numbers.contains(bombNumber)) {
            int currentIndex = numbers.indexOf(bombNumber);

            int leftBound = Math.max(0, currentIndex - bombPower);
            int rightBound = Math.min(numbers.size() - 1, currentIndex + bombPower);

            numbers.subList(leftBound, rightBound + 1).clear();
        }
        System.out.println(numbers.stream().mapToInt(Integer::intValue).sum());
    }
}
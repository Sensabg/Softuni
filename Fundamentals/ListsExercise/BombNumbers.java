package ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> specialBombNumber = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int counter = 0;

        while (counter <= specialBombNumber.get(1) && numbers.contains(specialBombNumber.get(0))) {
            int currentIndex = numbers.indexOf(specialBombNumber.get(0));
            counter++;
            if (currentIndex < numbers.size() - 1) {
                numbers.remove(currentIndex + 1);
            }
            if (currentIndex > 0) {
                numbers.remove(currentIndex - 1);
            }
            if (counter >= specialBombNumber.get(1)) {
                numbers.remove(specialBombNumber.get(0));
                counter = 0;
            }
        }
        //System.out.println(numbers);
        System.out.println(numbers.stream().mapToInt(Integer::intValue).sum());
    }
}
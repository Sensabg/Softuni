package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbers.length - 1; i++) {
            int currentNum = numbers[i];
            boolean isBigger = false;

            for (int j = i + 1; j <= numbers.length - 1; j++) {
                int compareNum = numbers[j];
                if (currentNum <= compareNum) {
                    isBigger = true;
                    break;
                }
            }
            if (!isBigger) {
                System.out.print(currentNum + " ");
            }
        }
        System.out.println(numbers[numbers.length - 1]);
    }
}
package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegersTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                              .mapToInt(Integer::parseInt)
                              .toArray();

        for (int j = 0; j < numbers.length - 1; j++) {
            if (numbers[j] > numbers[j + 1] && numbers[numbers.length - 1] < numbers[j]){
                System.out.print(numbers[j] + " ");
            }
        }
        System.out.println(numbers[numbers.length - 1]);
    }
}

package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int index = 0; index < numbers.length; index++) {

            int leftSum = 0;
            int rightSum = 0;

            for (int left = 0; left < index; left++) {
                leftSum += numbers[left];
            }
            for (int right = index + 1; right <= numbers.length - 1; right++) {
                rightSum += numbers[right];
            }
            if (rightSum == leftSum) {
                System.out.println(index);
                return;
            }
        }
        System.out.println("no");
    }
}
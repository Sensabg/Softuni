package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String elements = "";

        if (numbers.length == 1) {
            System.out.println(numbers[0]);
        } else {
            for (int i = 0; i < numbers.length - 1; i++) {
                int firstElement = numbers[i];
                for (int j = 1; j < numbers.length - 1; j++) {
                    if (firstElement < numbers[j] && numbers[j] < numbers[j + 1]) {
                        elements += firstElement + " " + numbers[j];
                    }
                }
            }
        }
            System.out.println(elements);
        }
    }



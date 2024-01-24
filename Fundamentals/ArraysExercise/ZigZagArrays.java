package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String one = "";
        String two = "";

        for (int i = 0; i < n; i++) {
    
            int[] numbers = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < numbers.length - 1; j++) {
                if (i % 2 == 0) {
                    one += numbers[j]+ " ";
                    two += numbers[j + 1]+ " ";
                } else {
                    one += numbers[j + 1]+ " ";
                    two += numbers[j] + " ";
                }
            }
        }
        System.out.println(one);
        System.out.println(two);
    }
}
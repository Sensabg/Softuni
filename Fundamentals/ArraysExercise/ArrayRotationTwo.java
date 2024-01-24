package ArraysExercise;

import java.util.Scanner;

public class ArrayRotationTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String firstElement = numbers[0];

            for (int j = 1; j < numbers.length; j++) {
                numbers[j - 1] = numbers[j];
            }
            numbers[numbers.length - 1] = firstElement;
        }
        System.out.println(String.join(" ", numbers));
    }
}
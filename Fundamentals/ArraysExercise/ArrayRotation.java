package ArraysExercise;

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        //51 47 32 61 21 ----------------> 32 61 21 51 47
        for (int i = 0; i < n; i++) {
            String firstElement = numbers[0];
            // Shift elements to the left
            for (int j = 0; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j + 1];
            }
            // Place the first element at the end
            numbers[numbers.length - 1] = firstElement;
        }
        System.out.println(String.join(" ", numbers));
    }
}
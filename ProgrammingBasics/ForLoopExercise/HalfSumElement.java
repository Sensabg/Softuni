package ForLoopExercise;

import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int maxNumber = Integer.MIN_VALUE;
        int number = 0;

        for (int i = 0; i < n; i++) {
            number = Integer.parseInt(scanner.nextLine());

            if (maxNumber < number) {
                maxNumber = number;
            }
                sum = (number + sum);

        }

        sum = sum - maxNumber;

        if (sum == maxNumber) {
            System.out.println("Yes");
            System.out.printf("Sum = %d", sum);
        } else {
            System.out.println("No");
            System.out.printf("Diff = %d", Math.abs(maxNumber - sum));
        }
    }
}

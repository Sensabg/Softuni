package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            String letters = scanner.nextLine();
            int length = letters.length();
            for (int j = 0; j <= length - 1; j++) {
                char letter = letters.charAt(j);
                sum = sum + letter;
            }
        }
        System.out.printf("The sum equals: %d",sum);
    }
}

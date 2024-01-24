package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String n = scanner.nextLine();
        int length = n.length();
        int count = 0;

        for (int i = 0; i <= length - 1; i++) {
            char sum = n.charAt(i);

            count += Character.getNumericValue(sum);
        }
        System.out.println(count);
    }
}

package BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.Scanner;

public class Messages3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int alphabetLength = alphabet.length();
        int n = Integer.parseInt(scanner.nextLine());

        String finalInput = "";

        for (int i = 0; i < n; i++) {
            String numbers = scanner.nextLine();
            int numberLength = numbers.length();
            int digit = Integer.parseInt(numbers);

            int delete = 0;

            if (numberLength == 1) {
                delete = 6;
            } else if (numberLength == 2) {
                digit /= 10;
                delete = 5;
            } else if (numberLength == 3) {
                digit /= 100;
                delete = 4;
            } else if (numberLength == 4) {
                digit /= 1000;
                delete = 3;
            }

            int offset = digit * 3 - delete;

            if (digit > 7 && digit <= 9) {
                offset++;
            }

            if (digit == 0) {
                finalInput += " ";
                continue;
            }

            if (offset >= 0 && offset < alphabetLength) {
                char alphabetic = alphabet.charAt(offset);
                finalInput += alphabetic;
            }
        }
        System.out.println(finalInput);
    }
}
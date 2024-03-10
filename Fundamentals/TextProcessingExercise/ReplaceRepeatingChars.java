package TextProcessingExercise;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char prevChar = input.charAt(i - 1);

            if (currentChar != prevChar) {
                resultBuilder.append(currentChar);
            }
        }
        System.out.println(resultBuilder);
    }
}
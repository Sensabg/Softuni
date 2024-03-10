package TextProcessingMoreExercise;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        String randomString = scanner.nextLine();

        int asciiSum = calculateAsciiSumBetweenChars(firstChar, secondChar, randomString);

        System.out.println(asciiSum);
    }

    private static int calculateAsciiSumBetweenChars(char startChar, char endChar, String inputString) {
        int asciiSum = 0;

        for (char currentChar : inputString.toCharArray()) {
            if (currentChar > startChar && currentChar < endChar) {
                asciiSum += currentChar;
            }
        }
        return asciiSum;
    }
}
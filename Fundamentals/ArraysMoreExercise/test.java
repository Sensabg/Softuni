package ArraysMoreExercise;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numStrings = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numStrings; i++) {

            String inputString = scanner.nextLine();

            int sum = 0;
            for (char c : inputString.toCharArray()) {
                if (isVowel(c)) {
                    sum += (int) c * inputString.length();
                } else if (Character.isLetter(c)) {
                    sum += (int) c / inputString.length();
                }
            }

            System.out.println("Encrypted result: " + sum);
        }

        scanner.close();
    }

    private static boolean isVowel(char c) {
        char lowerCaseC = Character.toLowerCase(c);
        return lowerCaseC == 'a' || lowerCaseC == 'e' || lowerCaseC == 'i' || lowerCaseC == 'o' || lowerCaseC == 'u';
    }
}
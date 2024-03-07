package TextProcessingExercise;

import java.util.Scanner;

public class CharacterMultiplier2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        int sum = calculateCharacterSum(words[0], words[1]);

        System.out.println(sum);
    }

    private static int calculateCharacterSum(String word1, String word2) {
        int sum = 0;
        int minSize = Math.min(word1.length(), word2.length());

        for (int i = 0; i < minSize; i++) {
            sum += word1.charAt(i) * word2.charAt(i);
        }

        sum += calculateRemainingSum(word1, minSize) + calculateRemainingSum(word2, minSize);

        return sum;
    }

    private static int calculateRemainingSum(String word, int start) {
        int sum = 0;

        for (int i = start; i < word.length(); i++) {
            sum += word.charAt(i);
        }

        return sum;
    }
}
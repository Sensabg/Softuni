package TextProcessingExercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        int minSize = Math.min(words[0].length(), words[1].length());
        int maxSize = Math.max(words[0].length(), words[1].length());
        int sum = 0;

        for (int i = 0; i < minSize; i++) {
            sum += words[0].charAt(i) * words[1].charAt(i);
        }
        if (words[0].length() > words[1].length()) {
            for (int i = minSize; i < maxSize; i++) {
                sum += words[0].charAt(i);
            }
        } else if(words[0].length() < words[1].length()) {
            for (int i = minSize; i < maxSize; i++) {
                sum += words[1].charAt(i);
            }
        }
        System.out.println(sum);
    }
}
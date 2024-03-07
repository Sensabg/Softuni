package TextProcessingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CharacterMultiplier3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        int minSize = Math.min(words[0].length(), words[1].length());
        int maxSize = Math.max(words[0].length(), words[1].length());

        int sum = IntStream.range(0, minSize)
                .map(i -> words[0].charAt(i) * words[1].charAt(i))
                .sum();

        sum += IntStream.range(minSize, maxSize)
                .map(i -> (words[0].length() > words[1].length()) ? words[0].charAt(i) : words[1].charAt(i))
                .sum();

        System.out.println(sum);
    }
}
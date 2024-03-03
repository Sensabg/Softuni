package MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().replaceAll("\\s+", "");
        LinkedHashMap<Character, Integer> chars = new LinkedHashMap<>();

        for (char symbol : input.toCharArray()) {
            chars.put(symbol, chars.getOrDefault(symbol, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}

package MapsLambdaAndStreamAPIExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class CountCharsInAString2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().replaceAll("\\s+", "");

        Map<Character, Integer> charCounts = input.chars()
                .mapToObj(c -> (char) c)
                .collect(HashMap::new,
                        (map, symbol) -> map.merge(symbol, 1, Integer::sum),
                        HashMap::putAll);

        charCounts.forEach((character, count) ->
                System.out.printf("%c -> %d%n", character, count));
    }
}
package RegularExpressionsMoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        String input;

        while (!"end".equals(input = scanner.nextLine())) {
            String regex = "@(?<childName>[A-Za-z]+)([^@\\-!:>]+)!(?<behavior>G)!";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input.chars()
                    .map(c -> c - key)
                    .mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.joining()));

            if (matcher.find()) {
                System.out.println(matcher.group("childName"));
            }
        }
    }
}
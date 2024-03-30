package RegularExpressionsMoreExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] info = input.split("\\|");

        String capitalLetters = info[0];
        String asciiLength = info[1];
        String words = info[2];

        LinkedHashMap<Character, Integer> charsSize = new LinkedHashMap<>();

        String regexCapitalLetters = "([#$%*&])(?<capitalLetters>[A-Z]+)\\1";
        Pattern pattern = Pattern.compile(regexCapitalLetters);
        Matcher matcher = pattern.matcher(capitalLetters);

        if (matcher.find()) {
            String letter = matcher.group("capitalLetters");

            for (int i = 0; i < letter.length(); i++) {
                charsSize.put(letter.charAt(i), 0);
            }
        }

        String regexFindDigits = "(?<asciiValue>[0-9]{2}):(?<length>[0-9]{2})";
        Pattern patternDigits = Pattern.compile(regexFindDigits);
        Matcher matchDigits = patternDigits.matcher(asciiLength);

        while (matchDigits.find()) {
            int asciiValue = Integer.parseInt(matchDigits.group("asciiValue"));
            int length = Integer.parseInt(matchDigits.group("length"));

            for (Map.Entry<Character, Integer> character : charsSize.entrySet()) {
                char currentChar = character.getKey();

                if (currentChar == asciiValue) {
                    charsSize.put(currentChar, length + 1);
                }
            }
        }

        String[] word = words.split("\\s+");

        for (Map.Entry<Character, Integer> character : charsSize.entrySet()) {
            char currentChar = character.getKey();
            int currentLength = character.getValue();

            for (int j = 0; j < word.length; j++) {
                String currentWord = word[j];
                if (currentWord.toCharArray()[0] == currentChar && currentLength == currentWord.length()) {
                    System.out.println(currentWord);
                }
            }
        }
    }
}
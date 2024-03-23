package FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> coolestEmojis = new ArrayList<>();

        String regexDigits = "\\d";
        Pattern patternDigits = Pattern.compile(regexDigits);
        Matcher matchDigits = patternDigits.matcher(input);
        int threshHold = 1;

        while (matchDigits.find()) {
            int digit = Integer.parseInt(matchDigits.group());
            threshHold *= digit;
        }

        System.out.println("Cool threshold: " + threshHold);

        String regex = "(?<specialSymbol>\\*\\*|::)(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int counter = 0;

        while (matcher.find()) {
            int sum = 0;
            counter++;
            String specialSymbol = matcher.group("specialSymbol");
            String emoji = matcher.group("emoji");

            for (char c : emoji.toCharArray()) {
                sum += c;
            }

            if(sum >= threshHold){
                coolestEmojis.add(specialSymbol + emoji + specialSymbol);
            }
        }
        System.out.println(counter + " emojis found in the text. The cool ones are: ");
        coolestEmojis.forEach(System.out::println);
    }
}
package RegularExpressionsMoreExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regexString = "\\D+";
        Pattern patternString = Pattern.compile(regexString);
        Matcher matchString = patternString.matcher(input);

        String regexDigits = "[0-9]+";
        Pattern patternDigits = Pattern.compile(regexDigits);
        Matcher matchDigits = patternDigits.matcher(input);

        StringBuilder stringBuilder = new StringBuilder();
        List<String> uniqueChars = new ArrayList<>();

        while (matchDigits.find()) {

            int repeat = Integer.parseInt(matchDigits.group());

            if (matchString.find()) {
                String currentString = matchString.group().toUpperCase().repeat(repeat);
                stringBuilder.append(currentString);

                for (int i = 0; i < currentString.length(); i++) {
                    if (!uniqueChars.contains(String.valueOf(currentString.charAt(i)))) {
                        uniqueChars.add(String.valueOf(currentString.charAt(i)));
                    }
                }
            }
        }
        System.out.println("Unique symbols used: " + uniqueChars.size());
        System.out.print(stringBuilder);
    }
}

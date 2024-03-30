90/100 ... :/

package RegularExpressionsMoreExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regexDigits = "[0-9]+";
        Pattern patch = Pattern.compile(regexDigits);

        List<String> uniqueSymbols = new ArrayList<>();

        String takeSymbols = input.toUpperCase().replaceAll(regexDigits, "");
        for (int i = 0; i < takeSymbols.length(); i++) {
            if (!uniqueSymbols.contains(String.valueOf(takeSymbols.charAt(i)))) {
                uniqueSymbols.add(String.valueOf(takeSymbols.charAt(i)));
            }
        }
        String regex = "(?<string>[^0-9]+)(?<repeats>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        StringBuilder stringBuilder = new StringBuilder();

        while (matcher.find()) {

            String string = matcher.group("string").toUpperCase();
            String repeats = matcher.group("repeats");
            Matcher matchDigits = patch.matcher(repeats);

            if (matchDigits.find()) {
                stringBuilder.append(string.repeat(Integer.parseInt(repeats)));
            }
        }
        System.out.println("Unique symbols used: " + uniqueSymbols.size());
        System.out.print(stringBuilder);
    }
}

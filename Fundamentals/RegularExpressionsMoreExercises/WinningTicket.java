package RegularExpressionsMoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s*,\\s+");
        String regex = "(?=.{20}).*?(?=(?<ch>[@#$^]))(?<match>\\k<ch>{6,}).*(?<=.{10})\\k<match>.*";
        Pattern pattern = Pattern.compile(regex);

        for (String string : input) {

            if (string.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                Matcher matcher = pattern.matcher(string);
                if (matcher.find()) {
                    String match = matcher.group("match");
                    System.out.printf("ticket \"%s\" - %d%s%s\n"
                            , string, match.length()
                            , match.charAt(0)
                            , (match.length() == 10) ? " Jackpot!" : "");
                } else {
                    System.out.printf("ticket \"%s\" - no match\n", string);
                }
            }
        }
    }
}
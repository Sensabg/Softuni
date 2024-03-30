package RegularExpressionsMoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tickets = scanner.nextLine().split("[,\\s]+");

        for (String ticket : tickets) {
            
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                String pattern = "([$|@|#|\\^]{6,})[\\s\\S]+?\\1";
                Matcher matcher = Pattern.compile(pattern).matcher(ticket.substring(0, 10) + " " + ticket.substring(10));

                if (matcher.find()) {
                    char symbol = matcher.group(1).charAt(0);
                    int count = matcher.group(1).length();

                    System.out.printf("ticket \"%s\" - %d%c%s\n", ticket, count, symbol, (count == 10) ? " Jackpot!" : "");
                } else {
                    System.out.printf("ticket \"%s\" - no match\n", ticket);
                }
            }
        }
    }
}

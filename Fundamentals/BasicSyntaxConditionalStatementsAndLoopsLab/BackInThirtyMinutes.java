package BasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class BackInThirtyMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        minutes += 30;

        if (minutes > 59) {
            hours += 1;
            minutes = 60 - minutes;
            if (hours > 23) {
                hours = 0;
            }
        }
        System.out.printf("%d:%02d", hours, Math.abs(minutes));
    }
}

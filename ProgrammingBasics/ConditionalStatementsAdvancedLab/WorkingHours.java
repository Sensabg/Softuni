package ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class WorkingHours {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        String day = scanner.nextLine();

        if (hours >= 10 && hours <= 18) {
            switch (day) {
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                case "Saturday":
                    System.out.println("open");
                    break;
                case "Sunday":
                    System.out.println("closed");
            }
        } else {
            System.out.println("closed");
        }
    }
}

package ArraysLab;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dayNumber = Integer.parseInt(scanner.nextLine());

        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };
        if (dayNumber >= 1 && dayNumber <= 7){
            String whichDay = days[dayNumber - 1];
            System.out.println(whichDay);
        } else {
            System.out.println("Invalid day!");
        }
    }
}

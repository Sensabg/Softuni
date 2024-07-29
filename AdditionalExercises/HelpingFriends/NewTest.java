package PersonalTasks;

import java.util.Scanner;

public class NewTest {
    public static final int AN_HOUR_IN_MINUTES = 60;
    public static final int HALF_AN_HOUR_IN_MINUTES = AN_HOUR_IN_MINUTES / 2;
    public static final int ZERO = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examMinutes = parseTime(scanner);
        int arrivalMinutes = parseTime(scanner);

        int timeDifference = arrivalMinutes - examMinutes;

        int hours = Math.abs(timeDifference / AN_HOUR_IN_MINUTES);
        int minutes = Math.abs(timeDifference % AN_HOUR_IN_MINUTES);

        String formatOutputHours = (hours == ZERO) ? "%01d minutes" : "%d:%02d hours";
        String time = String.format(formatOutputHours, (hours == ZERO) ? minutes : hours, minutes);

        boolean isLate = timeDifference > ZERO;
        boolean isEarly = Math.abs(timeDifference) > HALF_AN_HOUR_IN_MINUTES;
        boolean isNotRightOnTime = timeDifference != ZERO;

        if (!isEarly && !isLate) {
            System.out.println("On time" + String.format(isNotRightOnTime ? (" " + time + " before the start") : ("")));
        } else {
            System.out.print(isLate ? ("Late " + time + " after") : ("Early " + time + " before"));
            System.out.print(" the start");
        }
    }

    private static int parseTime(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine()) * AN_HOUR_IN_MINUTES + Integer.parseInt(scanner.nextLine());
    }
}
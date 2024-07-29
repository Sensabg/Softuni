package PersonalTasks;

import java.util.Scanner;

public class dadadada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examBeginInMinutes = Integer.parseInt(scanner.nextLine()) * 60 + Integer.parseInt(scanner.nextLine());
        int arrivalMinutes = Integer.parseInt(scanner.nextLine()) * 60 + Integer.parseInt(scanner.nextLine());

        int diffInMinutes = arrivalMinutes - examBeginInMinutes;

        int hours = Math.abs(diffInMinutes / 60);
        int minutes = Math.abs(diffInMinutes % 60);

        String formatOutputHours = (hours == 0) ? ("%01d minutes") : ("%d:%02d hours");
        String time = String.format(formatOutputHours, (hours == 0) ? minutes : hours, minutes);

        if (!(diffInMinutes > 0) && !(Math.abs(diffInMinutes) > 30)) {
            System.out.println(("On time") + String.format((diffInMinutes != 0) ? (" " + time + " before the start") : ""));
        } else {
            System.out.print((diffInMinutes > 0) ? ("Late " + time + " after") : ("Early " + time + " before") + (" the start"));
        }
    }
}
package PersonalTasks;

import java.util.Scanner;

public class OnTimeNew {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examStartInMinutes = Integer.parseInt(scanner.nextLine()) * 60 + Integer.parseInt(scanner.nextLine());
        int arrivalMinutes = Integer.parseInt(scanner.nextLine()) * 60 + Integer.parseInt(scanner.nextLine());

        int diffInMinutes = arrivalMinutes - examStartInMinutes;

        int hours = Math.abs(diffInMinutes / 60);
        int minutes = Math.abs(diffInMinutes % 60);

        String formattedTime = (hours == 0) ?
                String.format("%01d minutes", minutes) :
                String.format("%d:%02d hours", hours, minutes);

        if (diffInMinutes <= 0) {
            if (Math.abs(diffInMinutes) <= 30) {
                System.out.println("On time");
                if (diffInMinutes != 0) {
                    System.out.printf("%s before the start", formattedTime);
                }
            } else {
                System.out.printf("Early %s before the start", formattedTime);
            }
        } else {
            System.out.printf("Late %s after the start", formattedTime);
        }
    }
}

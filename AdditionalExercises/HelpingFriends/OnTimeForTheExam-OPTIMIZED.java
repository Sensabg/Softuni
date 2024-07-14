package PersonalTasks;

import java.util.Scanner;

public class OnTimeNew {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examStartInMinutes = readAndConvert(scanner);
        int arrivalMinutes = readAndConvert(scanner);

        int timeDiffInMinutes = arrivalMinutes - examStartInMinutes;

        int hours = Math.abs(timeDiffInMinutes / 60);
        int minutes = Math.abs(timeDiffInMinutes % 60);

        String formattedTime = (hours == 0) ?
                String.format("%01d minutes", minutes) :
                String.format("%d:%02d hours", hours, minutes);

        if (timeDiffInMinutes > 0) {
            System.out.printf("Late %s after the start", formattedTime);
        } else if (timeDiffInMinutes >= -30) {
            System.out.println("On time");
            if (timeDiffInMinutes != 0) {
                System.out.printf("%s before the start", formattedTime);
            }
        } else {
            System.out.printf("Early %s before the start", formattedTime);
        }
    }

    private static int readAndConvert(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine()) * 60 + Integer.parseInt(scanner.nextLine());
    }
}

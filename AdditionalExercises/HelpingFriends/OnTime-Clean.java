package PersonalTasks;

import java.util.Scanner;

public class OnTimeForTheExamSlavi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours;
        int minutes;

        hours = Integer.parseInt(scanner.nextLine());
        minutes = Integer.parseInt(scanner.nextLine());
        int examMinutes = hours * 60 + minutes;

        hours = Integer.parseInt(scanner.nextLine());
        minutes = Integer.parseInt(scanner.nextLine());
        int arrivalMinutes = hours * 60 + minutes;

        int timeDifference = arrivalMinutes - examMinutes;

        hours = Math.abs(timeDifference / 60);
        minutes = Math.abs(timeDifference % 60);

        String time;
        if (hours == 0) {
            time = String.format("%01d minutes", minutes);
        } else {
            time = String.format("%d:%02d hours", hours, minutes);
        }

        if (timeDifference <= 0) {
            if (Math.abs(timeDifference) <= 30) {
                System.out.println("On time");

                if (timeDifference != 0) {
                    System.out.printf("%s before the start", time);
                }
            } else {
                System.out.printf("Early %s before the start", time);
            }
        } else {
            System.out.printf("Late %s after the start", time);
        }
    }
}

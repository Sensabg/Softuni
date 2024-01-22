package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class OnTimefortheExam2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinutes = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinutes = Integer.parseInt(scanner.nextLine());

        int examTime = examHour * 60 + examMinutes;
        int arrivalTime = arrivalHour * 60 + arrivalMinutes;
        int timeDiff = Math.abs(examTime - arrivalTime);
        int hoursDiff = timeDiff / 60;
        int minutesDiff = timeDiff % 60;

        if (examTime == arrivalTime) {
            System.out.println("On time");
        } else if (examTime > arrivalTime && timeDiff <= 30) {
            System.out.println("On time");
            System.out.printf("%d minutes before the start%n", timeDiff);
        } else if (examTime > arrivalTime) {
            System.out.println("Early");
            if (hoursDiff > 0) {
                System.out.printf("%d:%02d hours before the start%n", hoursDiff, minutesDiff);
            } else {
                System.out.printf("%d minutes before the start%n", timeDiff);
            }
        } else {
            System.out.println("Late");
            if (hoursDiff > 0) {
                System.out.printf("%d:%02d hours after the start%n", hoursDiff, minutesDiff);
            } else {
                System.out.printf("%d minutes after the start%n", timeDiff);
            }
        }
    }
}

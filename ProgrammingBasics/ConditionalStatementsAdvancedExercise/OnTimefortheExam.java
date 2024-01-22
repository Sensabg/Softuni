package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class OnTimefortheExam {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinutes = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinutes = Integer.parseInt(scanner.nextLine());

        examHour = examHour * 60;
        arrivalHour = arrivalHour * 60;

        int totalExamMinutes = examHour + examMinutes;
        int totalArrivalMinutes = arrivalHour + arrivalMinutes;

        int timeMinutesDiff = Math.abs(totalExamMinutes - totalArrivalMinutes);
        int hoursDiff = Math.abs(totalExamMinutes - totalArrivalMinutes);

        if (timeMinutesDiff == 0) {
            System.out.println("On time");

        } else if (timeMinutesDiff <= 30 && totalExamMinutes > totalArrivalMinutes) {
            System.out.println("On time");
            System.out.printf("%d minutes before the start ", timeMinutesDiff);
        }
        if (totalArrivalMinutes > totalExamMinutes && timeMinutesDiff <= 59) {
            System.out.println("Late");
            System.out.printf("%d minutes after the start ", timeMinutesDiff);
        } else if (totalArrivalMinutes > totalExamMinutes) {
            timeMinutesDiff = timeMinutesDiff % 60;
            hoursDiff = hoursDiff / 60;
            System.out.println("Late");
            System.out.printf("%d:%02d hours after the start ", hoursDiff, timeMinutesDiff);
        }
        if (totalExamMinutes > totalArrivalMinutes && timeMinutesDiff <= 59) {
            System.out.println("Early");
            System.out.printf("%d minutes before the start ", timeMinutesDiff);
        } else if (totalArrivalMinutes < totalExamMinutes) {
            timeMinutesDiff = timeMinutesDiff % 60;
            hoursDiff = hoursDiff / 60;
            System.out.println("Early");
            System.out.printf("%d:%02d hours before the start ", hoursDiff, timeMinutesDiff);
        }
    }
}
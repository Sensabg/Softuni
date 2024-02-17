package MidExams;

import java.util.Scanner;

public class Problem1BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        int totalLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        int bestAttendance = 0;
        double maxBonus = Double.MIN_VALUE;

        for (int i = 0; i < numberOfStudents; i++) {
            int studentAttendances = Integer.parseInt(scanner.nextLine());
            double currentBonus =  studentAttendances * 1.0  / totalLectures * (5 + additionalBonus);

            if (currentBonus > maxBonus) {
                maxBonus = currentBonus;
                bestAttendance =  studentAttendances;
            }
        }
        System.out.printf("Max Bonus: %.0f.\n", maxBonus);
        System.out.printf("The student has attended %d lectures.\n", bestAttendance);
    }
}
package ForLoopMoreExercises;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double topStudents = 0;
        double averageStudents2 = 0;
        double averageStudents1 = 0;
        double failStudents = 0;

        double averageGrade = 0;

        int studentsAmount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < studentsAmount; i++) {
            double studentsGrades = Double.parseDouble(scanner.nextLine());

            averageGrade += studentsGrades;

            if (studentsGrades <= 2.99) {
                failStudents++;
            } else if (studentsGrades <= 3.99) {
                averageStudents1++;
            } else if (studentsGrades <= 4.99) {
                averageStudents2++;
            } else {
                topStudents++;
            }
        }
        failStudents = failStudents / studentsAmount * 100;
        averageStudents1 = averageStudents1 / studentsAmount * 100;
        averageStudents2 = averageStudents2 / studentsAmount * 100;
        topStudents = topStudents / studentsAmount * 100;
        averageGrade = averageGrade / studentsAmount;

        System.out.printf("\nTop students: %.2f%%", topStudents);
        System.out.printf("\nBetween 4.00 and 4.99: %.2f%%", averageStudents2);
        System.out.printf("\nBetween 3.00 and 3.99: %.2f%%", averageStudents1);
        System.out.printf("\nFail: %.2f%%", failStudents);
        System.out.printf("\nAverage: %.2f", averageGrade);
    }
}

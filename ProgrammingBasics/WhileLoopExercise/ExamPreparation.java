package WhileLoopExercise;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int badGrades = Integer.parseInt(scanner.nextLine());

        int badGradesCount = 0;
        int goodGradesCount = 0;
        int sumGrades = 0;
        int totalGrades = 0;

        boolean failed = false;

        String lastTask = "";
        String input = scanner.nextLine();
        while (!input.equals("Enough")) {

            String task = input;
            int grades = Integer.parseInt(scanner.nextLine());

            lastTask = task;
            sumGrades += grades;
            totalGrades++;

            if (grades <= 4) {
                badGradesCount++;
            } else {
                goodGradesCount++;
            }

            if (badGradesCount == badGrades) {
                failed = true;
                break;
            }
            input = scanner.nextLine();
        }

        double averageGrade = sumGrades / (totalGrades * 1.0);

        if (!failed) {
            System.out.printf("Average score: %.2f", averageGrade);
            System.out.printf("\nNumber of problems: %d", totalGrades);
            System.out.printf("\nLast problem: %s", lastTask);
        } else {
            System.out.printf("You need a break, %d poor grades.", badGradesCount);
        }
    }
}

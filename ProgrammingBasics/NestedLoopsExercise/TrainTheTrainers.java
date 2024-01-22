package NestedLoopsExercise;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double finalGrade = 0;
        int count = 0;

        String input = scanner.nextLine();

        while (!input.equals("Finish")) {
            String presentation = input;

            double sumCurrentGrade = 0;
            for (int i = 1; i <= n; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                count++;
                sumCurrentGrade += grade;
            }
            finalGrade += sumCurrentGrade;
            System.out.printf("%s - %.2f.\n", presentation, sumCurrentGrade / n);
            input = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", finalGrade / count);
    }
}


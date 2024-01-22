package WhileLoopLab;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String student = scanner.nextLine();
        double grades = Double.parseDouble(scanner.nextLine());

        int goodGradesCount = 0;
        int badGradesCount = 0;
        double gradeAverageCount = 0;
        int gradesCount = 0;

        while (goodGradesCount < 12) {

            gradeAverageCount += grades;

            if (grades < 4) {
                badGradesCount++;
                if (badGradesCount == 2) {
                    System.out.printf("%s has been excluded at %d grade", student, gradesCount);
                    break;
                }
            } else {
                goodGradesCount++;
                if (goodGradesCount == 12) {
                    gradeAverageCount = gradeAverageCount / 12;
                    System.out.printf("%s graduated. Average grade: %.2f", student, gradeAverageCount);
                    break;
                }
            }

            grades = Double.parseDouble(scanner.nextLine());
            gradesCount++;
        }
        scanner.close();
    }
}

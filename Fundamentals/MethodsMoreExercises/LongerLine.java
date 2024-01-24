package MethodsMoreExercises;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());
        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());

        printLongestLine(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    static void printLongestLine(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double result1 = Math.sqrt((Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2)));
        double result2 = Math.sqrt((Math.pow((x3 - x4), 2) + Math.pow((y3 - y4), 2)));
        if (result1 >= result2) {
            closestToZero(x1, y1, x2, y2);
        } else {
            closestToZero(x3, y3, x4, y4);
        }
    }

    private static void closestToZero(double x1, double y1, double x2, double y2) {
        double result1 = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double result2 = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));
        if (result1 <= result2) {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x1, y1, x2, y2);
        } else {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x2, y2, x1, y1);
        }
    }
}

package MethodsMoreExercises;

import java.util.Scanner;

public class test{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1_1 = scanner.nextDouble();
        double y1_1 = scanner.nextDouble();

        double x2_1 = scanner.nextDouble();
        double y2_1 = scanner.nextDouble();

        double x1_2 = scanner.nextDouble();
        double y1_2 = scanner.nextDouble();

        double x2_2 = scanner.nextDouble();
        double y2_2 = scanner.nextDouble();

        printLongerLine(x1_1, y1_1, x2_1, y2_1, x1_2, y1_2, x2_2, y2_2);
    }

    public static void printLongerLine(double x1, double y1, double x2, double y2,
                                       double x3, double y3, double x4, double y4) {
        double distance1 = Math.sqrt(x1 * x1 + y1 * y1);
        double distance2 = Math.sqrt(x2 * x2 + y2 * y2);
        double distance3 = Math.sqrt(x3 * x3 + y3 * y3);
        double distance4 = Math.sqrt(x4 * x4 + y4 * y4);

        double length1 = distance1 + distance2;
        double length2 = distance3 + distance4;

        if (length1 >= length2) {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)%n", x1, y1, x2, y2);
        } else {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)%n", x3, y3, x4, y4);
        }
    }
}



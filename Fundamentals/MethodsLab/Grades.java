package MethodsLab;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = Double.parseDouble(scanner.nextLine());

        printAndRateGrade(n);
    }
    public static void printAndRateGrade(double n) {
        String grade = "";
        if (n >= 2.00 && n <= 2.99) {
            grade = "Fail";
        } else if (n >= 3.00 && n <= 3.49) {
            grade = "Poor";
        } else if (n >= 3.50 && n <= 4.49) {
            grade = "Good";
        } else if (n >= 4.50 && n <= 5.49) {
            grade = "Very good";
        } else if (n >= 5.50 && n <= 6) {
            grade = "Excellent";
        }
        System.out.printf("%s", grade);
    }
}
package MethodsLab;

import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.0f",calculateRectangleArea(width,height));
    }
    public static double calculateRectangleArea (double width, double height){

        return width * height;
    }
}
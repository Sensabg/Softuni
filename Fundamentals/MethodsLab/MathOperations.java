package MethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double num2 = Double.parseDouble(scanner.nextLine());

        System.out.println(new DecimalFormat("0.##").format(calculate(num1,operator,num2)));
    }
    private static double calculate(double num1,String operator,double num2){
        double sum = 0;
        switch (operator){
            case"/":
                sum = num1 / num2;
                break;
            case"*":
                sum = num1 * num2;
                break;
            case"+":
                sum = num1 + num2;
                break;
            case"-":
                sum = num1 - num2;
                break;
        }
        return sum;
    }
}
package MethodsMoreExercises;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();

        switch (dataType) {
            case "int":
                int numberInt = Integer.parseInt(scanner.nextLine());
                multiplyInts(numberInt);
                break;
            case "real":
                double numberDouble = Double.parseDouble(scanner.nextLine());
                multiplyDoubles(numberDouble);
                break;
            case "string":
                String txt = scanner.nextLine();
                concatenate$$(txt);
                break;
        }
    }
    public static void multiplyInts(int num){
        System.out.println(num * 2);
    }
    public static void multiplyDoubles(double num){
        System.out.println(new DecimalFormat("0.00").format(num * 1.5));
    }
    public static void concatenate$$(String txt){
        System.out.println("$" + txt + "$");
    }
}
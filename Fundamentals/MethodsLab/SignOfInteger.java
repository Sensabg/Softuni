package MethodsLab;

import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        signOfAnInteger(n);
    }
    public static void signOfAnInteger(int n){
        if(n < 0){
            System.out.printf("The number %d is negative.",n);
        } else if ( n > 0 ){
            System.out.printf("The number %d is positive.",n);
        } else {
            System.out.print("The number 0 is zero.");
        }
    }
}
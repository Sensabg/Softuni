package MethodsMoreExercises;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = 0;
        int n2 = 0;
        int n3 = 1;

        int n = scanner.nextInt();

        if (n > 0) {
            System.out.print(1 + " ");
        }

        for (int i = n; i > 1; --i) {
            int num = n1 + n2 + n3;
            System.out.print(num + " ");
            n1 = n2;
            n2 = n3;
            n3 = num;
        }
    }
}

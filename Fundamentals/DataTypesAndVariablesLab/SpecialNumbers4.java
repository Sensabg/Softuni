package DataTypesAndVariablesLab;

import java.util.Scanner;

public class SpecialNumbers4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
             if (i % 10 + i / 10 == 5 || i % 10 + i / 10 == 7 || i % 10 + i / 10 == 11) {
                System.out.printf("%d -> True\n", i);
            } else {
                 System.out.printf("%d -> False\n", i);
             }
        }
    }
}
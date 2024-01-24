package DataTypesAndVariablesLab;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {

            int f = i % 10;
            int m = i / 10;
            int sum = f + m;

            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.printf("%d -> True", i);
                System.out.println();
            } else {
                System.out.printf("%d -> False", i);
                if (i == n) {
                    break;
                }
                System.out.println();
            }
        }
    }
}
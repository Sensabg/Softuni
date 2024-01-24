package DataTypesAndVariablesLab;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int ch = 1; ch <= number; ch++) {

            int object2 = ch % 10;
            int object = ch / 10;
            int total = object2 + object;

            if (total == 5 || total == 7 || total == 11) {
                System.out.printf("%d -> True", ch);
                System.out.println();
            } else {
                System.out.printf("%d -> False", ch);
                if (ch == number) {
                    break;
                }
                System.out.println();
            }
        }
    }
}
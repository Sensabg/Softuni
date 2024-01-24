package DataTypesAndVariablesLab;

import java.util.Scanner;

public class SpecialNumbers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String n = scanner.nextLine();
        int number = Integer.parseInt(n);

        for (int i = 1; i <= number; i++) {

            String ok = String.valueOf(i);

            char one = ok.charAt(0);
            char two = 0;
            int sum;

            if (i > 9) {
                two = ok.charAt(1);
                sum = Character.getNumericValue(one) + Character.getNumericValue(two);
            } else {
                sum = Character.getNumericValue(one) + two;
            }

            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.printf("%d -> True", i);
                System.out.println();
            } else {
                System.out.printf("%d -> False", i);
                if (i == number) {
                    break;
                }
                System.out.println();
            }
        }
    }
}

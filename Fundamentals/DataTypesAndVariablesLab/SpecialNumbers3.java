package DataTypesAndVariablesLab;

import java.util.Scanner;

public class SpecialNumbers3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {

            String extract = String.valueOf(i);
            char one = extract.charAt(0);
            char two = (i > 9) ? extract.charAt(1) : '0';
            int sum = Character.getNumericValue(one) + Character.getNumericValue(two);

            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.printf("%d -> True\n", i);
            } else {
                System.out.printf("%d -> False\n", i);
            }
        }
    }
}
//Extract the first character (one) from ok.
//If i is greater than 9, extract the second character (two) from ok; otherwise, set two to '0'.
package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        boolean firstNumberFound = false;

        for (int i = 1; i <= n; i++) {

            String numbers = scanner.nextLine();
            int check = numbers.length();
            firstNumberFound = false;
            String n1 = "";
            String n2 = "";
            int n3 = 0;
            int n4 = 0;

            for (int j = 0; j < check; j++) {
                char perSymbol = numbers.charAt(j);
                String n11 = "" + Character.getNumericValue(Math.abs(perSymbol));

                if (!firstNumberFound) {
                    if (perSymbol == 32) {
                        firstNumberFound = true;
                        continue;
                    }
                    n1 += n11;
                    n3 += Character.getNumericValue(Math.abs(perSymbol));
                } else {
                    n2 += n11;
                    n4 += Character.getNumericValue(Math.abs(perSymbol));
                }
            }
            if (Math.abs(Long.parseLong(n1)) > Math.abs(Long.parseLong(n2))) {
                System.out.println(Math.abs(n3));
            } else {
                System.out.println(Math.abs(n4));
            }
        }
    }
}
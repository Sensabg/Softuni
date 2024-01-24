package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class FromLeftToRight2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String numbers = scanner.nextLine();
            int check = numbers.length();
            boolean firstNumberFound = false;
            long sum1 = 0;
            long sum2 = 0;

            for (int j = 0; j < check; j++) {
                char perSymbol = numbers.charAt(j);
                if (!firstNumberFound) {
                    if (perSymbol == ' ') {
                        firstNumberFound = true;
                        continue;
                    }
                    sum1 += Character.getNumericValue(perSymbol);
                } else {
                    sum2 += Character.getNumericValue(perSymbol);
                }
            }

            int comparisonResult = Long.compare(sum1, sum2);

            if (comparisonResult > 0) {
                System.out.println(sum1);
            } else {
                System.out.println(sum2);
            }
        }
    }
}


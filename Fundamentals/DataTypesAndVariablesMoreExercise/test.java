package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String left = scanner.next();
            String right = scanner.next();
            int n1 = 0;
            int n2 = 0;

            if (Math.abs(Long.parseLong(left)) > Math.abs(Long.parseLong(right))) {
                for (int j = 0; j <= left.length()- 1; j++) {
                    char perSymbol = left.charAt(j);
                    n1 += Character.getNumericValue(Math.abs(perSymbol));
                    if (j == left.length() -1) {
                        System.out.println(Math.abs(n1));
                    }
                }
            } else {
                for (int j = 0; j <= right.length() -1; j++) {
                    char perSymbol = right.charAt(j);
                    n2 += Character.getNumericValue(Math.abs(perSymbol));
                    if (j == right.length() -1) {
                        System.out.println(Math.abs(n2));
                    }
                }
            }
        }
    }
}

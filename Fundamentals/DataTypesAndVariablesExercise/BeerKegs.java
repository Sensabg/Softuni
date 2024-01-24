package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double best = 0;
        String biggest = "";

        for (int i = 1; i <= n; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            double height = Integer.parseInt(scanner.nextLine());

            double formula = Math.PI * Math.pow(radius, 2) * height;

            if(formula > best) {
                best = formula;
                biggest = model;
            }
        }
        System.out.printf("%s",biggest);
    }
}

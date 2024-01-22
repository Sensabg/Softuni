package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String projection = scanner.nextLine();
        double columns = Double.parseDouble(scanner.nextLine());
        double rows = Double.parseDouble(scanner.nextLine());

        double income = 0.0;

        switch (projection) {

            case "Premiere":
                income = columns * rows * 12.00;
                break;
            case "Normal":
                income = columns * rows * 7.50;
                break;
            case "Discount":
                income = columns * rows * 5.00;
                break;

        }
        System.out.printf("%.2f", income);

    }
}

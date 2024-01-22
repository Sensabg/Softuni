package ConditionalStatementsMoreExercises;

import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String DayOrNight = scanner.nextLine();

        String One = "day";
        String Two = "night";

        double taxi = 0;
        double bus = n * 0.09;
        double train = n * 0.06;

        if (One.equals(DayOrNight)) {
            taxi = 0.70 + n * 0.79;
        } else if (Two.equals(DayOrNight)) {
            taxi = 0.70 + n * 0.90;
        }

        if (n < 20) {
            System.out.printf("%.2f",taxi);
        } else if (n >= 100) {
            System.out.printf("%.2f", train);
        } else if (n >= 20) {
            System.out.printf("%.2f",bus);
        }
    }
}
package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double bestValue = 0;
        int bestSnowballQuality = Integer.MAX_VALUE;
        int bestSnowballTime = Integer.MAX_VALUE;
        int bestSnowballSnow = 0;

        for (int i = 1; i <= n; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            int snowBall = (snowballSnow / snowballTime);
            double snowballValue = Math.pow(snowBall, snowballQuality);

            if (bestValue < snowballValue) {
                bestValue = snowballValue;
                bestSnowballQuality = snowballQuality;
                bestSnowballTime = snowballTime;
                bestSnowballSnow = snowballSnow;
            }

            if (i == n) {
                System.out.printf("\n%d : %d = %.0f (%d)", bestSnowballSnow, bestSnowballTime, bestValue, bestSnowballQuality);
                break;
            }
        }
    }
}

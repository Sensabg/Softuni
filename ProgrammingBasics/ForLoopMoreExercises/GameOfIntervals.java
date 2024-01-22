package ForLoopMoreExercises;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int gameMoves = Integer.parseInt(scanner.nextLine());

        double totalPoints = 0;

        double counter1 = 0;
        double counter2 = 0;
        double counter3 = 0;
        double counter4 = 0;
        double counter5 = 0;

        double counterInvalid = 0;

        for (int i = 0; i < gameMoves; i++) {
            int numbers = Integer.parseInt(scanner.nextLine());

            if (numbers >= 0 && numbers <= 9) {
                totalPoints += numbers * 0.20;
                counter1++;
            } else if (numbers >= 10 && numbers <= 19) {
                totalPoints += numbers * 0.30;
                counter2++;
            } else if (numbers >= 20 && numbers <= 29) {
                totalPoints += numbers * 0.40;
                counter3++;
            } else if (numbers >= 30 && numbers <= 39) {
                totalPoints += 50;
                counter4++;
            } else if (numbers >= 40 && numbers <= 50) {
                totalPoints += 100;
                counter5++;
            } else {
                totalPoints /= 2;
                counterInvalid++;
            }
        }
        counter1 = counter1 / gameMoves * 100;
        counter2 = counter2 / gameMoves * 100;
        counter3 = counter3 / gameMoves * 100;
        counter4 = counter4 / gameMoves * 100;
        counter5 = counter5 / gameMoves * 100;

        counterInvalid = counterInvalid / gameMoves * 100;

        System.out.printf("%.2f", totalPoints);
        System.out.printf("\nFrom 0 to 9: %.2f%%", counter1);
        System.out.printf("\nFrom 10 to 19: %.2f%%", counter2);
        System.out.printf("\nFrom 20 to 29: %.2f%%", counter3);
        System.out.printf("\nFrom 30 to 39: %.2f%%", counter4);
        System.out.printf("\nFrom 40 to 50: %.2f%%", counter5);
        System.out.printf("\nInvalid numbers: %.2f%%", counterInvalid);
    }
}
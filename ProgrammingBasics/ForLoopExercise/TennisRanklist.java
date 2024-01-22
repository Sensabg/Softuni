package ForLoopExercise;

import java.util.Scanner;

public class TennisRanklist {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int competitionAmount = Integer.parseInt(scanner.nextLine());
        int startingPoints = Integer.parseInt(scanner.nextLine());
        int points = 0;
        int totalPoints = 0;

        int w = 0;
        int f = 0;
        int sf = 0;

        for (int i = 0; i < competitionAmount; i++) {
            String competitionType = (scanner.nextLine());

            switch (competitionType) {
                case "W":
                    w++;
                    points = 2000;
                    startingPoints += 2000;
                    totalPoints += points;
                    break;
                case "F":
                    f++;
                    points = 1200;
                    startingPoints += 1200;
                    totalPoints += points;
                    break;
                case "SF":
                    sf++;
                    points = 720;
                    startingPoints += 720;
                    totalPoints += points;
                    break;
            }
        }
        double averagePoints = Math.floor((totalPoints * 1.0) / competitionAmount);
        double amountWins = (w * 1.0) / competitionAmount * 100;

        System.out.printf("\nFinal points: %d", startingPoints);
        System.out.printf("\nAverage points: %.0f", averagePoints);
        System.out.printf("\n%.2f%%", amountWins);
    }
}

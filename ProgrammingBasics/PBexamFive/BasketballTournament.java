package PBexamFive;

import java.util.Scanner;

public class BasketballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tournament = scanner.nextLine();
        int amountMatches = Integer.parseInt(scanner.nextLine());

        boolean win = false;

        int winCounterTeamOne = 0;
        int winCounterTeamTwo = 0;

        int totalGames = 0;

        String name = "";

        while (true) {

            int gamesCounter = 0;

            for (int i = 0; i < amountMatches; i++) {

                name = tournament;

                int teamOne = Integer.parseInt(scanner.nextLine());
                int teamTwo = Integer.parseInt(scanner.nextLine());

                win = false;

                int totalPointsTeamOne = 0;
                int totalPointsTeamTwo = 0;

                gamesCounter++;

                if (teamOne > teamTwo) {
                    totalPointsTeamOne += teamOne - teamTwo;
                    winCounterTeamOne++;
                    win = true;
                } else {
                    totalPointsTeamTwo += teamTwo - teamOne;
                    winCounterTeamTwo++;
                }

                if (win) {
                    totalGames++;
                    System.out.printf("Game %d of tournament %s: win with %d points.\n", gamesCounter, name, totalPointsTeamOne);
                } else {
                    totalGames++;
                    System.out.printf("Game %d of tournament %s: lost with %d points.\n", gamesCounter, name, totalPointsTeamTwo);
                }
            }

            tournament = scanner.nextLine();

            if (tournament.equals("End of tournaments")) {
                break;
            }

            amountMatches = Integer.parseInt(scanner.nextLine());
        }

        double winRate = (winCounterTeamOne * 100.0) / totalGames;
        double loseRate = (winCounterTeamTwo * 100.0) / totalGames;

        System.out.printf("%.2f%% matches win\n", winRate);
        System.out.printf("%.2f%% matches lost", loseRate);

    }
}

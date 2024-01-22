package PBexamThree;

import java.util.Scanner;

public class FootballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String team = scanner.nextLine();
        int gamesPlayed = Integer.parseInt(scanner.nextLine());

        int winCounter = 0;
        int drawCounter = 0;
        int loseCounter = 0;

        int points = 0;

        if (gamesPlayed <= 0) {
            System.out.printf("%s hasn't played any games during this season.", team);
            return;
        }

        for (int i = 0; i < gamesPlayed; i++) {
            String winDrawLose = scanner.nextLine();

            switch (winDrawLose) {
                case "W":
                    winCounter++;
                    points = points + 3;
                    break;
                case "D":
                    drawCounter++;
                    points = points + 1;
                    break;
                case "L":
                    loseCounter++;
                    break;
            }
        }
        System.out.printf("%s has won %d points during this season.\n",team, points);
        System.out.println("Total stats:");
        System.out.printf("## W: %d\n", winCounter);
        System.out.printf("## D: %d\n", drawCounter);
        System.out.printf("## L: %d\n", loseCounter);
        System.out.printf("Win rate: %.2f%%\n", (winCounter * 100.0) / gamesPlayed);
    }
}

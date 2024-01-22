package PBexamTwo;

import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tournamentDays = Integer.parseInt(scanner.nextLine());

        int loseCounter = 0;
        int winCounter = 0;

        int dayLoseCounter = 0;
        int dayWinCounter = 0;

        double moneyPerWin = 0;
        double totalMoney = 0;

        for (int i = 0; i < tournamentDays; i++) {

            String command = scanner.nextLine();

            while (!"Finish".equals(command)) {
                String sport = command;
                String winOrLose = scanner.nextLine();
                switch (winOrLose) {
                    case "win":
                        winCounter++;
                        moneyPerWin += 20;
                        break;
                    case "lose":
                        loseCounter++;
                        break;
                }
                command = scanner.nextLine();
            }

            if (winCounter > loseCounter) {
                moneyPerWin = moneyPerWin + (moneyPerWin * 0.10);
                dayWinCounter++;
            } else {
                dayLoseCounter++;
            }

            loseCounter = 0;
            winCounter = 0;
            totalMoney += moneyPerWin;
            moneyPerWin = 0;
        }

        if (dayWinCounter > dayLoseCounter) {
            totalMoney += totalMoney * 0.20;
        }

        if (dayWinCounter > dayLoseCounter) {
            System.out.printf("You won the tournament! Total raised money: %.2f", totalMoney);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", totalMoney);
        }
    }
}

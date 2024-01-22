package PBexamTwo;

import java.util.Scanner;

public class TournamentOfChristmas2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int daysOfTournament = Integer.parseInt(scanner.nextLine());

        double charity = 0;
        double dayCharity=0;
        int win = 0;
        int loose = 0;
        int dayWin = 0;
        int dayLoose = 0;

        for (int i = 1; i <= daysOfTournament; i++) {
            String sport = scanner.nextLine();
            while (!sport.equals("Finish")) {
                String result = scanner.nextLine();
                switch (result) {
                    case "win":
                        win++;
                        dayCharity += 20;
                        break;
                    case "lose":
                        loose++;
                        break;
                }
                sport = scanner.nextLine();
            }
            if (win > loose) {
                dayCharity *= 1.10;
                dayWin++;
            } else {
                dayLoose++;
            }
            win = 0;
            loose = 0;
            charity+=dayCharity;
            dayCharity=0;
        }
        if (dayWin > dayLoose) {
            charity *= 1.20;
        }
        if (dayWin > dayLoose) {
            System.out.printf("You won the tournament! Total raised money: %.2f", charity);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", charity);
        }
    }
}

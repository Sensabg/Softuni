package PBexamFour;

import java.util.Scanner;

public class FavMovie2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);



            String bestMovie = "";
            int points = 0;
            int currentPoints = 0;
            int movieCounter = 0;
            int minusPoints = 0;
            int bestPoints = 0;

            String command = scanner.nextLine();
            while (true) {
                String movieName = command;
                if (command.equals("STOP")) {
                    break;
                }

                movieCounter++;

                if (movieCounter == 7) {
                    break;
                }

                minusPoints = movieName.length();

                char currentLetter;

                for (int i = 0; i < movieName.length(); i++) {
                    char letter = movieName.charAt(i);
                    currentLetter = letter;
                    currentPoints = currentLetter;

                    if (currentLetter >= 65 && currentLetter <= 90) {
                        currentPoints -= minusPoints;
                    } else if (currentLetter >= 97 && currentLetter <= 122) {
                        currentPoints -= minusPoints * 2;
                    }

                    points += currentPoints;
                }

                if (points > bestPoints) {
                    bestMovie = movieName;
                    bestPoints = points;
                }

                points = 0;
                minusPoints = 0;
                command = scanner.nextLine();
            }

            if (movieCounter == 7) {
                System.out.println("The limit is reached.");
            }

            System.out.printf("The best movie for you is %s with %d ASCII sum.", bestMovie, bestPoints);
        }
}

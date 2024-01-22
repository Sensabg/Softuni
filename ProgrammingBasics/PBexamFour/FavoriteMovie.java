package PBexamFour;

import java.util.Scanner;


public class FavoriteMovie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String bestMovie = "";
        int counter = 0;
        int bestSum = 0;
        int points = 0;


        String command = scanner.nextLine();
        while (!"STOP".equals(command)) {
            String movie = command;

            counter++;

            int sum = 0;

            char currentLetter = 0;
            int length = movie.length();

            for (int i = 0; i < length; i++) {

                char letter = movie.charAt(i);
                currentLetter = letter;
                points = currentLetter;

                if (Character.isUpperCase(letter)) {
                    points = letter - length;
                } else if (Character.isLowerCase(letter)) {
                    points = letter - (length + length);
                }

                sum += points;
            }

            if (sum > bestSum) {
                bestSum = sum;
                bestMovie = movie;
            }

            if (counter == 7) {
                System.out.println("The limit is reached.");
                break;
            }

            command = scanner.nextLine();
        }
        System.out.printf("The best movie for you is %s with %d ASCII sum.", bestMovie, bestSum );
    }
}

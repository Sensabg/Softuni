package NestedLoopsMoreExercises;

import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char lastSector = scanner.nextLine().charAt(0);
        int amountLinesSectorOne = Integer.parseInt(scanner.nextLine());
        int oddLines = Integer.parseInt(scanner.nextLine());

        int evenLines = oddLines + 2;
        int totalSeats = 0;

        for (char sector = 'A'; sector <= lastSector; sector++) {
            for (int line = 1; line <= amountLinesSectorOne; line++) {
                int seatsOnCurrentLine = (line % 2 == 1) ? oddLines : evenLines;

                for (char seat = 'a'; seat < 'a' + seatsOnCurrentLine; seat++) {
                    System.out.printf("%c%d%c%n", sector, line, seat);
                    totalSeats++;
                }
            }
            amountLinesSectorOne++;
        }

        System.out.println(totalSeats);
    }
}

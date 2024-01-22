package PBexamFour;

import java.util.Scanner;

public class SeriesCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String series = scanner.nextLine();
        int amountSeasons = Integer.parseInt(scanner.nextLine());
        int amountEpisodes = Integer.parseInt(scanner.nextLine());
        double duration = Double.parseDouble(scanner.nextLine());

        double commercialDuration = duration * 0.20;
        double durationWithCommercials = duration + commercialDuration;
        double specialEpisodesDuration = amountSeasons * 10;

        double totalDuration = (durationWithCommercials * amountEpisodes * amountSeasons) + specialEpisodesDuration;

        System.out.printf("Total time needed to watch the %s series is %.0f minutes.",series,Math.floor(totalDuration));
    }
}

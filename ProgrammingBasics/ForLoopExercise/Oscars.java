package ForLoopExercise;

import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String actorName = scanner.nextLine();
        double startingPoints = Double.parseDouble(scanner.nextLine());
        int jury = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < jury; i++) {
            String juryName = scanner.nextLine();
            double juryPoints = Double.parseDouble(scanner.nextLine());
            int pointsFromName = juryName.length();

            startingPoints += (pointsFromName * juryPoints) / 2;

            if (startingPoints >= 1250.5) {
                System.out.printf("\nCongratulations, %s got a nominee for leading role with %.1f!", actorName, startingPoints);
                return;
            }
        }
        System.out.printf("Sorry, %s you need %.1f more!", actorName, Math.abs(startingPoints - 1250.5));
    }
}

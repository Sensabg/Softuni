package ForLoopMoreExercises;

import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int stadiumCapacity = Integer.parseInt(scanner.nextLine());

        int totalFans = Integer.parseInt(scanner.nextLine());

        double fansA = 0;
        double fansB = 0;
        double fansV = 0;
        double fansG = 0;

        for (int i = 0; i < totalFans; i++) {
            String sector = scanner.nextLine();

            switch (sector) {
                case "A":
                    fansA++;
                    break;
                case "B":
                    fansB++;
                    break;
                case "V":
                    fansV++;
                    break;
                case "G":
                    fansG++;
                    break;
            }
        }

        fansA = fansA / totalFans * 100;
        fansB = fansB / totalFans * 100;
        fansV = fansV / totalFans * 100;
        fansG = fansG / totalFans * 100;

        double totalFansPercent = (totalFans * 1.0) / stadiumCapacity * 100;

        System.out.printf("%.2f%%",fansA);
        System.out.printf("\n%.2f%%",fansB);
        System.out.printf("\n%.2f%%",fansV);
        System.out.printf("\n%.2f%%",fansG);
        System.out.printf("\n%.2f%%",totalFansPercent);
    }
}

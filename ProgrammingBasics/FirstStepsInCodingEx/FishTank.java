package FirstStepsInCodingEx;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int l = Integer.parseInt(scanner.nextLine());
        int w = Integer.parseInt(scanner.nextLine());
        int h = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        int volume = l * w * h;
        double volumeConvert = volume / 1000.0;

        double convertPercent = percent / 100;

        double neededLitres = volumeConvert * ( 1 - convertPercent);

        System.out.println(neededLitres);


    }
}

package PBexamThree;

import java.util.Scanner;

public class PCGameShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gamesSell = Integer.parseInt(scanner.nextLine());

        int hsCounter = 0;
        int gayCounter = 0;
        int owCounter = 0;
        int othersCounter = 0;

        for (int i = 0; i < gamesSell; i++) {
            String game = scanner.nextLine();
            switch (game) {
                case "Hearthstone":
                    hsCounter++;
                    break;
                case "Fornite":
                    gayCounter++;
                    break;
                case "Overwatch":
                    owCounter++;
                    break;
                default:
                    othersCounter++;
                    break;
            }
        }
        System.out.printf("Hearthstone - %.2f%%\n",(hsCounter * 100.0) /gamesSell);
        System.out.printf("Fornite - %.2f%%\n",(gayCounter * 100.0) /gamesSell);
        System.out.printf("Overwatch - %.2f%%\n",(owCounter * 100.0) /gamesSell);
        System.out.printf("Others - %.2f%%\n",(othersCounter * 100.0) /gamesSell);
    }
}

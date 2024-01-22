package PBexamOne;

import java.util.Scanner;

public class Balls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int points = 0;

        int redCounter = 0;
        int orangeCounter = 0;
        int yellowCounter = 0;
        int whiteCounter = 0;
        int blackCounter = 0;
        int otherCounter = 0;


        for (int i = 0; i < n; i++) {
            String ballsColor = scanner.nextLine();

            switch (ballsColor) {
                case "red":
                    redCounter++;
                    points += 5;
                    break;
                case "orange":
                    orangeCounter++;
                    points += 10;
                    break;
                case "yellow":
                    yellowCounter++;
                    points += 15;
                    break;
                case "white":
                    whiteCounter++;
                    points += 20;
                    break;
                case "black":
                    blackCounter++;
                    points = points / 2;
                    break;
                default:
                     otherCounter++;

            }
        }
        System.out.printf("Total points: %d",points);
        System.out.printf("\nRed balls: %d",redCounter);
        System.out.printf("\nOrange balls: %d",orangeCounter);
        System.out.printf("\nYellow balls: %d",yellowCounter);
        System.out.printf("\nWhite balls: %d",whiteCounter);
        System.out.printf("\nOther colors picked: %d",otherCounter);
        System.out.printf("\nDivides from black balls: %d",blackCounter);
    }
}

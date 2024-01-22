package NestedLoopsMoreExercises;

import java.util.Scanner;

public class ChallengeTheWedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amountM = Integer.parseInt(scanner.nextLine());
        int amountF = Integer.parseInt(scanner.nextLine());
        int tables = Integer.parseInt(scanner.nextLine());

        int counter = 0;

        for (int i = 1; i <= amountM; i++) {
            for (int j = 1; j <= amountF; j++) {
                counter++;

                if (counter <= tables) {
                    System.out.print(("(" + i + " " + "<->" + " " + j + ")" + " "));
                }


            }
        }
    }
}

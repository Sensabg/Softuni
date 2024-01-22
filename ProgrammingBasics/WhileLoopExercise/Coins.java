package WhileLoopExercise;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());
        double coinsInput = Math.round(input * 100);

        int counter = 0;

        while (coinsInput > 0) {
            if (coinsInput >= 200) {
                counter++;
                coinsInput = Math.round(coinsInput - 200);
            } else if (coinsInput >= 100) {
                counter++;
                coinsInput = Math.round(coinsInput - 100);
            } else if (coinsInput >= 50) {
                counter++;
                coinsInput = Math.round(coinsInput - 50);
            } else if (coinsInput >= 20) {
                counter++;
                coinsInput = Math.round(coinsInput - 20);
            } else if (coinsInput >= 10) {
                counter++;
                coinsInput = Math.round(coinsInput - 10);
            } else if (coinsInput >= 5) {
                counter++;
                coinsInput = Math.round(coinsInput - 5);
            } else if (coinsInput >= 2) {
                counter++;
                coinsInput = Math.round(coinsInput - 2);
            } else if (coinsInput >= 1) {
                counter++;
                coinsInput = Math.round(coinsInput - 1);
            }
        }
        System.out.println(counter);
    }
}

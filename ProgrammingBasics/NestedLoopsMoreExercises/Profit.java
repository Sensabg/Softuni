package NestedLoopsMoreExercises;

import java.util.Scanner;

public class Profit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int one = Integer.parseInt(scanner.nextLine());
        int two = Integer.parseInt(scanner.nextLine());
        int five = Integer.parseInt(scanner.nextLine());
        int money = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i <= one; i++) {
            for (int j = 0; j <= two; j++) {
                for (int k = 0; k <= five; k++) {

                    if ((i * 1) + (j * 2) + (k * 5) == money) {
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.\n", i, j, k, money);

                    }
                }
            }
        }
    }
}

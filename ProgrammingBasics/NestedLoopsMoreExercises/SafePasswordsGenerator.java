package NestedLoopsMoreExercises;

import java.util.Scanner;

public class SafePasswordsGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int max = Integer.parseInt(scanner.nextLine());

        String test = "";
        int counter = 0;

        for (char u = 35; u <= 55; u++) {
            for (char i = 64; i <= 96; i++) {
                for (int j = 1; j <= a; j++) {
                    for (int k = 1; k <= b; k++) {

                        counter++;

                        test = u + "" + i + j + k + i + u ;

                        if(counter >= 1){
                            u++;
                            i++;
                        }

                        if (u > 55) {
                            u = 35;
                        }

                        if (i > 96) {
                            i = 64;
                        }
                        System.out.print(test + "|");

                        if(j == a && k == b || counter == max){
                            return;
                        }

                    }
                }
            }

        }
    }
}
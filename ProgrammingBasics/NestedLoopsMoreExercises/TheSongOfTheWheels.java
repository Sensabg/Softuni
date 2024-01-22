package NestedLoopsMoreExercises;

import java.util.Scanner;

public class TheSongOfTheWheels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int controlNumber = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        boolean passwordFound = false;
        String password = "";

        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <= 9; d++) {

                        if (((a * b) + (c * d) == controlNumber) && (b > a) && (c > d)) {
                            counter++;
                            System.out.print(a + "" + b + c + d + " ");
                            if(counter == 4){
                                passwordFound = true;
                                password = a + "" + b + c + d;
                            }
                        }

                    }
                }
            }
        }
        if (passwordFound){
            System.out.printf("\nPassword: %s", password);
        } else {
            System.out.println("\nNo!");
        }
    }
}

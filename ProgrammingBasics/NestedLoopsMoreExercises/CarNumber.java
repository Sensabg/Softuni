package NestedLoopsMoreExercises;

import java.util.Scanner;

public class CarNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());

        for (int i = numOne; i <= numTwo; i++) {
            for (int j = numOne; j <= numTwo; j++) {
                for (int k = numOne; k <= numTwo; k++) {
                    for (int l = numOne; l <= numTwo; l++) {

                        if(((i % 2 == 0 && l % 2 != 0) || (i %2 != 0 && l % 2 ==0)) && ( i>l) && ((j + k) % 2 ==0)){
                            System.out.print(i + "" + j + k + l + " " );
                        }


                    }
                }
            }
        }

    }
}

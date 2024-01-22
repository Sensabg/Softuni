package DrawingFiguresWithLoopsMoreExercises;

import java.util.Scanner;

public class SquareFrame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        int counterTwo = 0;
        int counterThree = 0;

        int diff = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (counter == n) {
                    counter++;
                }

                if (counter % 2 == 0) {
                    System.out.print("+");
                    if (counter == 2) {
                        System.out.println();
                    }
                }

                counter++;

                if (i + j == n || counterTwo / 4 == 1) {
                    counterThree++;
                    if(counterThree % 3 == 0){
                        counterTwo++;
                        counterThree++;
                        System.out.print(" ");
                    }
                    System.out.print("|");
                    counterTwo = 0;

                    if ( counterThree == 2){
                        System.out.println();
                        System.out.print("|");
                        counter++;
                    }
                }

                for (int k = 0; k <= n - 2; k++) {
                    counterTwo++;
                    System.out.print(" ");
                    if (counterTwo == n) {
                        break;
                    }
                    System.out.print("-");

                }

            }

        }
    }
}
package DrawingFiguresWithLoopsMoreExercises;

import java.util.Scanner;

public class SquarePart3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row < n; row++) {
            if (row == 0 || row == n - 1) {
                System.out.print("+");
                for (int col = 0; col < n - 2; col++) {
                    System.out.print(" -");
                }
                System.out.println(" +");

            } else {
                System.out.print("|");
                for (int col = 0; col < n - 2; col++) {
                    System.out.print(" -");
                }
                System.out.println(" |");

            }
        }
    }
}


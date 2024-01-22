package DrawingFiguresWithLoopsMoreExercises;

import java.util.Scanner;

public class SquarePart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            if (i == 1 || i % n == 0) {
                System.out.print("+ ");
            } else {
                System.out.print("| ");
            }
            for (int j = 1; j <= n - 2; j++) {
                System.out.print("- ");
                if (n - 2 == j) {
                    if (j + i == n || j + i >= n) {
                        if (i == n) {
                            System.out.print("+");
                            break;
                        }
                        System.out.print("|");
                    } else {
                        System.out.print("+");
                    }
                }
            }
            System.out.println(" ");
        }
    }
}

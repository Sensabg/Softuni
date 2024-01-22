package DrawingFiguresWithLoopsMoreExercises;

import java.util.Scanner;

public class TriangleOfDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int number = 1;
        boolean isNumber = false;

        for (int rows = 1; rows <= n; rows++) {
            for (int cols = 1; cols <= rows; cols++) {
                number--;
                if (n < number) {
                    isNumber = true;
                    break;
                }
                System.out.print("$" + " ");
                number++;
            }
            if(isNumber){
                break;
            }
            System.out.println();
        }
    }
}
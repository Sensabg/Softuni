package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class T06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            matrix[i] = readArray(scanner);
        }

        for (int i = 0; i < matrix.length; i++) {
                System.out.print(matrix[i][i] + " ");
        }

        System.out.println();

        int rows = dimension - 1;
        int cols = 0;

        while(rows >= 0 && cols < dimension){
            System.out.print(matrix[rows][cols] + " ");
            rows--;
            cols++;
        }

    }
    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

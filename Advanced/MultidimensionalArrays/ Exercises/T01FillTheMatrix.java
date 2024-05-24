
package MultidimensionalArrays.Ex;

import java.util.Scanner;

public class T01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        int dimensions = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[dimensions][dimensions];

        switch (pattern) {

            case "A":
                fillMatrixA(matrix, dimensions);
                break;

            case "B":
                fillMatrixB(matrix, dimensions);
                break;
        }
        printMatrix(matrix);
    }

    private static void fillMatrixB(int[][] matrix, int dimensions) {
        int value = 1;

        for (int i = 0; i < dimensions; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < dimensions; j++) {
                    matrix[j][i] = value++;
                }
            } else {
                for (int j = dimensions - 1; j >= 0; j--) {
                    matrix[j][i] = value++;
                }
            }
        }
    }

    private static void fillMatrixA(int[][] matrix, int dimensions) {
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                matrix[i][j] = i + j * dimensions + 1;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] getMatrix(int dimensions) {

        String[][] matrix = new String[dimensions][];
        for (int rows = 0; rows < dimensions; rows++) {
            for (int cols = 0; cols < dimensions; cols++) {
                matrix[rows][cols] = rows + "";
                System.out.println(matrix[rows][cols]);
            }
        }
        return matrix;
    }
}

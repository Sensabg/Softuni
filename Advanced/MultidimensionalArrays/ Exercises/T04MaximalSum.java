package MultidimensionalArrays.Ex;

import java.util.Arrays;
import java.util.Scanner;

public class T04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int[][] subMatrix = new int[3][3];

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= matrix.length - 3; i++) {
            for (int j = 0; j <= matrix[i].length - 3; j++) {

                int sum = 0;

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        sum += matrix[i + k][j + l];
                    }
                }

                if (maxSum < sum) {
                    maxSum = sum;

                    for (int row = 0; row < 3; row++) {
                        System.arraycopy(matrix[i + row], j, subMatrix[row], 0, 3);
                    }
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int[] row : subMatrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] dimensions = readArray(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

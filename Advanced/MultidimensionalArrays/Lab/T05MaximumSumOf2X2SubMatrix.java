package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class T05MaximumSumOf2X2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int topSum = Integer.MIN_VALUE;
        int[] bestNumbers = new int[4];

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int topLeft = matrix[i][j];
                int topRight = matrix[i][j + 1];
                int botLeft = matrix[i + 1][j];
                int botRight = matrix[i + 1][j + 1];

                int sum = topLeft + topRight + botLeft + botRight;

                if (topSum < sum) {
                    topSum = sum;
                    bestNumbers[0] = topLeft;
                    bestNumbers[1] = topRight;
                    bestNumbers[2] = botLeft;
                    bestNumbers[3] = botRight;
                }
            }
        }
        for (int i = 0; i < bestNumbers.length - 1; i+=2) {
            System.out.println(bestNumbers[i] + " " + bestNumbers[i + 1]);
        }
        System.out.println(topSum);
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
        return Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}

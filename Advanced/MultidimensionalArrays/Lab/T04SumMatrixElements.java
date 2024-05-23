package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class T04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int totalCount = sumElements(matrix);

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(totalCount);
    }

    private static int sumElements(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                count += matrix[i][j];
            }
        }
        return count;
    }

    private static int[][] readMatrix(Scanner scanner) {

        int dimensions[] = readArray(scanner);

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

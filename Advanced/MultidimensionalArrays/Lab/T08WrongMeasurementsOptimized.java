package MultidimensionalArrays;

import java.util.*;

public class T08WrongMeasurementsOptimized {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int[] position = readArray(scanner);
        int row = position[0];
        int col = position[1];

        int removeElement = matrix[row][col];

        int[][] updatedMatrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            updatedMatrix[i] = matrix[i].clone();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == removeElement) {
                    updatedMatrix[i][j] = getSum(i, j, matrix, removeElement);
                }
            }
        }
        printMatrix(updatedMatrix);
    }

    private static int getSum(int i, int j, int[][] matrix, int removeElement) {
        int sum = 0;
        if (isValidPosition(matrix, i - 1, j) && matrix[i - 1][j] != removeElement) {
            sum += matrix[i - 1][j];
        }
        if (isValidPosition(matrix, i, j - 1) && matrix[i][j - 1] != removeElement) {
            sum += matrix[i][j - 1];
        }
        if (isValidPosition(matrix, i + 1, j) && matrix[i + 1][j] != removeElement) {
            sum += matrix[i + 1][j];
        }
        if (isValidPosition(matrix, i, j + 1) && matrix[i][j + 1] != removeElement) {
            sum += matrix[i][j + 1];
        }
        return sum;
    }

    private static boolean isValidPosition(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    public static int[][] readMatrix(Scanner scanner) {
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }
        return matrix;
    }

    public static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
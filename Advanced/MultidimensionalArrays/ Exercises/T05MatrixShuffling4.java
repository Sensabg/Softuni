package MultidimensionalArrays.Ex;

import java.util.Arrays;
import java.util.Scanner;

public class T05MatrixShuffling4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = readMatrix(scanner, rows, cols);

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("END")) {
                break;
            }
            if (!processCommand(command, matrix)) {
                System.out.println("Invalid input!");
            }
        }
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner, cols);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner, int size) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(size)
                .toArray();
    }

    private static boolean processCommand(String command, int[][] matrix) {
        String[] tokens = command.split("\\s+");
        if (tokens.length != 5 || !tokens[0].equals("swap")) {
            return false;
        }
        int row1 = Integer.parseInt(tokens[1]);
        int col1 = Integer.parseInt(tokens[2]);
        int row2 = Integer.parseInt(tokens[3]);
        int col2 = Integer.parseInt(tokens[4]);

        if (isValidSwap(row1, col1, row2, col2, matrix)) {
            swapElements(matrix, row1, col1, row2, col2);
            printMatrix(matrix);
            return true;
        }
        return false;
    }

    private static boolean isValidSwap(int row1, int col1, int row2, int col2, int[][] matrix) {
        return isValidIndex(row1, col1, matrix) && isValidIndex(row2, col2, matrix) && (row1 != row2 || col1 != col2);
    }

    private static boolean isValidIndex(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    private static void swapElements(int[][] matrix, int row1, int col1, int row2, int col2) {
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
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
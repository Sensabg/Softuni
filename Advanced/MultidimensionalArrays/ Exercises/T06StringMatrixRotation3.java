package MultidimensionalArrays.Ex;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T06StringMatrixRotation3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotationDegrees = Integer.parseInt(scanner.nextLine().substring(7).replace(")", ""));

        ArrayDeque<String> queue = new ArrayDeque<>();
        int maxCols = 0;
        String line;
        while (!(line = scanner.nextLine()).equals("END")) {
            queue.offer(line);
            maxCols = Math.max(maxCols, line.length());
        }

        char[][] matrix = new char[queue.size()][maxCols];
        fillMatrix(queue, matrix, 0);
        char[][] rotatedMatrix = rotateMatrix(matrix, rotationDegrees);
        printMatrix(rotatedMatrix, 0);
    }

    private static void fillMatrix(ArrayDeque<String> queue, char[][] matrix, int rowIndex) {
        if (queue.isEmpty()) {
            return;
        }
        String line = queue.poll();
        for (int col = 0; col < line.length(); col++) {
            matrix[rowIndex][col] = line.charAt(col);
        }
        fillMatrix(queue, matrix, rowIndex + 1);
    }

    private static char[][] rotateMatrix(char[][] matrix, int degrees) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] rotatedMatrix = new char[cols][rows];

        rotate(matrix, rotatedMatrix, 0, 0, degrees % 360);
        return rotatedMatrix;
    }

    private static void rotate(char[][] matrix, char[][] rotatedMatrix, int row, int col, int degrees) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (row >= rows || col >= cols) {
            return;
        }
        int newRow = col;
        int newCol = rows - 1 - row;

        rotatedMatrix[newRow][newCol] = matrix[row][col];
        rotate(matrix, rotatedMatrix, newRow, newCol, degrees);
    }

    private static void printMatrix(char[][] matrix, int rowIndex) {
        if (rowIndex >= matrix.length) {
            return;
        }
        System.out.println(new String(matrix[rowIndex]).trim());
        printMatrix(matrix, rowIndex + 1);
    }
}
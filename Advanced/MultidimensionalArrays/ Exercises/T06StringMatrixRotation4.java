package MultidimensionalArrays.Ex;

import java.util.ArrayDeque;
import java.util.Scanner;

class T06StringMatrixRotation4 {
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

        char[][] matrix = fillMatrix(queue, maxCols);
        char[][] rotatedMatrix = rotateMatrix(matrix, rotationDegrees);
        printMatrix(rotatedMatrix);
    }

    private static char[][] fillMatrix(ArrayDeque<String> queue, int maxCols) {
        char[][] matrix = new char[queue.size()][maxCols];
        int rowIndex = 0;
        for (String line : queue) {
            for (int col = 0; col < line.length(); col++) {
                matrix[rowIndex][col] = line.charAt(col);
            }
            rowIndex++;
        }
        return matrix;
    }

    private static char[][] rotateMatrix(char[][] matrix, int degrees) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] rotatedMatrix = new char[cols][rows];

        degrees %= 360;

        if (degrees < 0) {
            degrees += 360;
        }
        rotate(matrix, rotatedMatrix, 0, 0, degrees);
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

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println(new String(row).trim());
        }
    }
}
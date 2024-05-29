package MultidimensionalArrays.Ex;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T06StringMatrixRotation5 {
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
        char[][] rotatedMatrix;

        degrees %= 360;
        if (degrees < 0) {
            degrees += 360;
        }

        if (degrees == 0) {
            rotatedMatrix = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                System.arraycopy(matrix[i], 0, rotatedMatrix[i], 0, cols);
            }
            return rotatedMatrix;
        }

        rotatedMatrix = new char[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int newRow, newCol;
                switch (degrees) {
                    case 90:
                        newRow = j;
                        newCol = rows - 1 - i;
                        break;
                    case 180:
                        newRow = rows - 1 - i;
                        newCol = cols - 1 - j;
                        break;
                    case 270:
                        newRow = cols - 1 - j;
                        newCol = i;
                        break;
                    default:
                        newRow = i;
                        newCol = j;
                }
                rotatedMatrix[newRow][newCol] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println(new String(row).trim());
        }
    }
}
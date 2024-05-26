package MultidimensionalArrays.Ex;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T06StringMatrixRotation1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int startIndex = input.indexOf("(") + 1;
        int endIndex = input.indexOf(")");
        int rotationDegrees = Integer.parseInt(input.substring(startIndex, endIndex));

        ArrayDeque<String> queue = new ArrayDeque<>();
        int horizontalBound = Integer.MIN_VALUE;

        do {
            input = scanner.nextLine();
            if (!"END".equals(input)) {
                queue.offer(input);
                if (horizontalBound < input.length()) {
                    horizontalBound = input.length();
                }
            }
        } while (!"END".equals(input));

        int verticalBound = queue.size();
        char[][] defaultBoard = new char[verticalBound][horizontalBound];

        int rowIndex = 0;

        for (String line : queue) {
            for (int col = 0; col < line.length(); col++) {
                defaultBoard[rowIndex][col] = line.charAt(col);
            }
            rowIndex++;
        }
        char[][] rotatedMatrix = rotateMatrix(defaultBoard, rotationDegrees);
        printMatrix(rotatedMatrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println(new String(row).trim());
        }
    }

    private static char[][] rotateMatrix(char[][] matrix, int degrees) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] rotatedMatrix = new char[cols][rows];

        int rotation = (degrees / 90) % 4;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int newIndex = getNewIndex(rotation, i, j, rows, cols);
                rotatedMatrix[newIndex / rows][newIndex % rows] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    private static int getNewIndex(int rotation, int i, int j, int rows, int cols) {
        switch (rotation) {
            case 1:
                return j * rows + rows - 1 - i;
            case 2:
                return (rows - 1 - i) * cols + cols - 1 - j;
            case 3:
                return (cols - 1 - j) * rows + i;
            default:
                return i * cols + j;
        }
    }
}
package MultidimensionalArrays.Ex;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class T06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int startIndex = input.indexOf("(") + 1;
        int endIndex = input.indexOf(")");
        int rotationDegrees = Integer.parseInt(input.substring(startIndex, endIndex));

        ArrayDeque<String> queue = new ArrayDeque<>();
        int horizontalBound = Integer.MIN_VALUE;

        while (!"END".equals(input = scanner.nextLine())) {
            queue.offer(input);
            if (horizontalBound < input.length()) {
                horizontalBound = input.length();
            }
        }
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

    private static char[][] rotateMatrix(char[][] matrix, int degrees) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int rotatedRows = (degrees == 90 || degrees == 270) ? cols : rows;
        int rotatedCols = (degrees == 90 || degrees == 270) ? rows : cols;

        char[][] rotatedMatrix = new char[rotatedRows][rotatedCols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int newIndex = getNewIndex(degrees, i, j, rows, cols);
                rotatedMatrix[newIndex / rotatedCols][newIndex % rotatedCols] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    private static int getNewIndex(int rotation, int i, int j, int rows, int cols) {
        switch (rotation) {
            case 90:
                return j * rows + rows - 1 - i;
            case 180:
                return (rows - 1 - i) * cols + cols - 1 - j;
            case 270:
                return (cols - 1 - j) * rows + i;
            default:
                return i * cols + j;
        }
    }
    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix)
                .map(row -> String.valueOf(row).replaceAll("\0", " "))
                .forEach(System.out::println);
    }
}
package MultidimensionalArrays.Ex;

import java.util.Scanner;

public class T06StringMatrixRotation7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotationCommand = scanner.nextLine().trim();

        int degree = Integer.parseInt(
                rotationCommand.substring(rotationCommand.indexOf("(") + 1,
                        rotationCommand.indexOf(")")));

        StringBuilder sb = new StringBuilder();
        String line = scanner.nextLine().trim();
        while (!line.equals("END")) {
            sb.append(line).append("\n");
            line = scanner.nextLine().trim();
        }

        String[] matrixLines = sb.toString().split("\n");
        char[][] matrix = new char[matrixLines.length][];
        int maxLength = 0;

        for (int i = 0; i < matrixLines.length; i++) {
            matrix[i] = matrixLines[i].toCharArray();
            maxLength = Math.max(maxLength, matrix[i].length);
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length < maxLength) {
                char[] paddedLine = new char[maxLength];
                System.arraycopy(matrix[i], 0, paddedLine, 0, matrix[i].length);
                for (int j = matrix[i].length; j < maxLength; j++) {
                    paddedLine[j] = ' ';
                }
                matrix[i] = paddedLine;
            }
        }
        char[][] rotatedMatrix = rotateMatrix(matrix, degree);
        for (char[] row : rotatedMatrix) {
            System.out.println(row);
        }
    }
    public static char[][] rotateMatrix(char[][] matrix, int degree) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int numRotations = degree / 90;

        for (int rotation = 0; rotation < numRotations; rotation++) {
            char[][] rotatedMatrix = new char[cols][rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    rotatedMatrix[j][rows - i - 1] = matrix[i][j];
                }
            }
            matrix = rotatedMatrix;
            int temp = rows;
            rows = cols;
            cols = temp;
        }
        return matrix;
    }
}
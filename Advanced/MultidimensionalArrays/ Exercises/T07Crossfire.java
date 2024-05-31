package MultidimensionalArrays.Ex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class T07Crossfire {
    public static int startingPoint = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);
        int[][] matrix = generateMatrix(dimensions);

        String command;
        while (!"Nuke it from orbit".equals(command = scanner.nextLine())) {
            int[] removeArea = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix = removeElements(matrix, removeArea);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            if (row.length > 0) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }

    private static int[][] removeElements(int[][] matrix, int[] removeArea) {
        int targetRow = removeArea[0];
        int targetCol = removeArea[1];
        int range = removeArea[2];
        
        for (int row = Math.max(targetRow - range, 0); row <= Math.min(targetRow + range, matrix.length - 1); row++) {
            if (isValid(row, targetCol, matrix)) {
                matrix[row][targetCol] = -1;
            }
        }
        
        if (isValid(targetRow, 0, matrix)) {
            for (int col = Math.max(targetCol - range, 0); col <= Math.min(targetCol + range, matrix[targetRow].length - 1); col++) {
                matrix[targetRow][col] = -1;
            }
        }

        return cleanMatrix(matrix);
    }

    private static boolean isValid(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int[][] cleanMatrix(int[][] matrix) {
        List<List<Integer>> cleaned = new ArrayList<>();

        for (int[] row : matrix) {
            List<Integer> newRow = new ArrayList<>();
            for (int value : row) {
                if (value != -1) {
                    newRow.add(value);
                }
            }
            if (!newRow.isEmpty()) {
                cleaned.add(newRow);
            }
        }

        int[][] cleanedMatrix = new int[cleaned.size()][];
        for (int i = 0; i < cleaned.size(); i++) {
            cleanedMatrix[i] = cleaned.get(i).stream().mapToInt(Integer::intValue).toArray();
        }

        return cleanedMatrix;
    }

    private static int[][] generateMatrix(int[] dimensions) {
        int[][] matrix = new int[dimensions[0]][dimensions[1]];
        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                matrix[i][j] = startingPoint++;
            }
        }
        return matrix;
    }

    public static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

package MultidimensionalArrays;

import java.util.*;

public class T08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int[] position = readArray(scanner);
        int row = position[0];
        int col = position[1];

        int removeElement = matrix[row][col];

        ArrayDeque<Integer> saveSumQue = new ArrayDeque<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == removeElement) {
                    int sum = getSum(i, matrix, j, removeElement);
                    saveSumQue.offer(sum);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == removeElement && !saveSumQue.isEmpty()) {
                    matrix[i][j] = saveSumQue.poll();
                }
            }
        }


        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }

    private static int getSum(int i, int[][] matrix, int j, int removeElement) {

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
        return r >= 0 && r < matrix.length
                && c >= 0 && c < matrix[r].length;
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
}

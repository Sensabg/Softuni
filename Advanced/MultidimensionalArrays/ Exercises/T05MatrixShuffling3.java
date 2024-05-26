package MultidimensionalArrays.Ex;

import java.util.Arrays;
import java.util.Scanner;

public class T05MatrixShuffling3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        String command;

        while (!"END".equals(command = scanner.nextLine())) {
            String[] tokens = command.split("\\s+");

            if (tokens.length == 5) {

                int[] indices = {
                        Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]),
                        Integer.parseInt(tokens[3]),
                        Integer.parseInt(tokens[4]),
                };

                if (isValidIndices(indices, matrix)) {
                    int temp = matrix[indices[0]][indices[1]];
                    matrix[indices[0]][indices[1]] = matrix[indices[2]][indices[3]];
                    matrix[indices[2]][indices[3]] = temp;

                    printMatrix(matrix);

                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static boolean isValidIndices(int[] indices, int[][] matrix) {
        for (int i = 0; i < 4; i += 2) {
            if (!isValidIndex(indices[i], indices[i + 1], matrix.length, matrix[0].length)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidIndex(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}

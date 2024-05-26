package MultidimensionalArrays.Ex;

import java.util.Scanner;

public class T05MatrixShuffling2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[][] matrix = readMatrix(scanner, rows, cols);

        while (true) {
            String command = scanner.nextLine().trim();
            if (command.equals("END")) {
                break;
            }

            String[] tokens = command.split("\\s+");

            if (tokens.length != 5 || !tokens[0].equals("swap")) {
                System.out.println("Invalid input!");
                continue;
            }

            try {
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                if (!isValidIndex(row1, col1, rows, cols) || !isValidIndex(row2, col2, rows, cols)) {
                    System.out.println("Invalid input!");
                    continue;
                }

                String temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = temp;

                printMatrix(matrix);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }

        scanner.close();
    }

    private static boolean isValidIndex(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static String[][] readMatrix(Scanner scanner, int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = elements[j];
            }
        }

        return matrix;
    }
}
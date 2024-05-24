package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class T07FindTheRealQueen3 {
    private static final int BOARD_SIZE = 8;
    private static final int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},  // Up, down, left, right
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // Diagonals
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = readMatrix(scanner);

        for (int rows = 0; rows < BOARD_SIZE; rows++) {
            for (int cols = 0; cols < BOARD_SIZE; cols++) {
                if (board[rows][cols] == 'q' && isValidQueen(board, rows, cols)) {
                    System.out.println(rows + " " + cols);
                    return;
                }
            }
        }
    }

    private static boolean isValidQueen(char[][] board, int rows, int cols) {
        for (int[] direction : DIRECTIONS) {
            int newRow = rows + direction[0];
            int newCol = cols + direction[1];
            while (isValidPosition(newRow, newCol)) {
                if (board[newRow][newCol] == 'q') {
                    return false;
                }
                newRow += direction[0];
                newCol += direction[1];
            }
        }
        return true;
    }

    private static boolean isValidPosition(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE;
    }

    public static char[][] readMatrix(Scanner scanner) {
        char[][] matrix = new char[BOARD_SIZE][];
        for (int i = 0; i < BOARD_SIZE; i++) {
            matrix[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }
}
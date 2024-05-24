package MultidimensionalArrays.Lab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T07FindTheRealQueen2 {
    private static final int BOARD_SIZE = 8;

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
        Map<String, int[]> directions = new HashMap<>();
        directions.put("up", new int[]{-1, 0});
        directions.put("down", new int[]{1, 0});
        directions.put("left", new int[]{0, -1});
        directions.put("right", new int[]{0, 1});
        directions.put("topLeft", new int[]{-1, -1});
        directions.put("topRight", new int[]{-1, 1});
        directions.put("botLeft", new int[]{1, -1});
        directions.put("botRight", new int[]{1, 1});

        for (int[] direction : directions.values()) {
            int newRow = rows += direction[0];
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
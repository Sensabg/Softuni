package MultidimensionalArrays.Lab;

import java.util.Scanner;
import java.util.stream.IntStream;

public class T07FindTheRealQueen4 {
    private static final int BOARD_SIZE = 8;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            char[][] board = readMatrix(scanner);
            IntStream.range(0, BOARD_SIZE)
                    .boxed()
                    .flatMap(row -> IntStream.range(0, BOARD_SIZE)
                            .filter(col -> board[row][col] == 'q' && isValidQueen(board, row, col))
                            .mapToObj(col -> row + " " + col))
                    .forEach(System.out::println);
        }
    }

    private static boolean isValidQueen(char[][] board, int row, int col) {
        return IntStream.of(-1, 0, 1)
                .boxed()
                .flatMap(r -> IntStream.of(-1, 0, 1)
                        .filter(c -> r != 0 || c != 0)
                        .mapToObj(c -> traverseDirection(board, row, col, r, c)))
                .allMatch(Boolean::booleanValue);
    }

    private static boolean traverseDirection(char[][] board, int row, int col, int rowDirection, int colDirection) {
        int r = row + rowDirection;
        int c = col + colDirection;
        while (isWithinArray(board, r, c)) {
            if (board[r][c] == 'q') return false;
            r += rowDirection;
            c += colDirection;
        }
        return true;
    }

    private static boolean isWithinArray(char[][] board, int currentRow, int currentCol) {
        return currentRow >= 0 && currentRow < board.length && currentCol >= 0 && currentCol < board[currentRow].length;
    }

    private static char[][] readMatrix(Scanner scanner) {
        char[][] matrix = new char[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            matrix[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }
}
package MultidimensionalArrays;

import java.util.Scanner;

public class T07FindTheRealQueen0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessboard = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            for (int j = 0; j < 8; j++) {
                chessboard[i][j] = parts[j].charAt(0);
            }
        }

        int[] validQueenPosition = findValidQueen(chessboard);

        if (validQueenPosition != null) {
            System.out.println(validQueenPosition[0] + " " + validQueenPosition[1]);
        }
    }

    private static int[] findValidQueen(char[][] chessboard) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (chessboard[row][col] == 'q') {
                    if (isValidQueen(chessboard, row, col)) {
                        return new int[]{row, col};
                    }
                }
            }
        }
        return null;
    }

    private static boolean isValidQueen(char[][] chessboard, int row, int col) {
        // Check row
        for (int c = 0; c < 8; c++) {
            if (c != col && chessboard[row][c] == 'q') {
                return false;
            }
        }

        // Check column
        for (int r = 0; r < 8; r++) {
            if (r != row && chessboard[r][col] == 'q') {
                return false;
            }
        }

        // Check diagonals
        for (int i = 1; i < 8; i++) {
            if (row + i < 8 && col + i < 8 && chessboard[row + i][col + i] == 'q') {
                return false;
            }
            if (row - i >= 0 && col - i >= 0 && chessboard[row - i][col - i] == 'q') {
                return false;
            }
            if (row + i < 8 && col - i >= 0 && chessboard[row + i][col - i] == 'q') {
                return false;
            }
            if (row - i >= 0 && col + i < 8 && chessboard[row - i][col + i] == 'q') {
                return false;
            }
        }

        return true;
    }
}

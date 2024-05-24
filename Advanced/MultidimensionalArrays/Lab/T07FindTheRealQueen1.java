package MultidimensionalArrays;

import java.util.Scanner;

public class T07FindTheRealQueen1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessBoard = readMatrix(scanner);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (chessBoard[row][col] == 'q' && isValidQueen(chessBoard, row, col)) {
                    System.out.println(row + " " + col);
                    return;
                }
            }
        }
    }

    private static boolean isValidQueen(char[][] chessBoard, int row, int col) {
        // Check row
        for (int c = 0; c < 8; c++) {
            if (c != col && chessBoard[row][c] == 'q') {
                return false;
            }
        }
        // Check column
        for (int r = 0; r < 8; r++) {
            if (r != row && chessBoard[r][col] == 'q') {
                return false;
            }
        }
        // Check diagonals
        for (int i = 1; i < 8; i++) {
            if (row + i < 8 && col + i < 8 && chessBoard[row + i][col + i] == 'q') {
                return false;
            }
            if (row - i >= 0 && col - i >= 0 && chessBoard[row - i][col - i] == 'q') {
                return false;
            }
            if (row + i < 8 && col - i >= 0 && chessBoard[row + i][col - i] == 'q') {
                return false;
            }
            if (row - i >= 0 && col + i < 8 && chessBoard[row - i][col + i] == 'q') {
                return false;
            }
        }
        return true;
    }

    public static char[][] readMatrix(Scanner scanner) {

        char[][] matrix = new char[8][];
        for (int i = 0; i < 8; i++) {
            matrix[i] = scanner.nextLine().replaceAll("\\s+","").toCharArray();
        }
        return matrix;
    }
}
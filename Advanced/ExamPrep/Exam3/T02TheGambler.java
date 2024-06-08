package ExamPrep.Exam3;

import java.util.Scanner;

public class T02TheGambler {
    private static int side;
    private static int[] coordinates = new int[2];
    private static int balance = 100;
    private static String direction;

    private static boolean isWinner = false;
    private static boolean isLooser = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        side = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[side][side];

        for (int i = 0; i < side; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < side; j++) {
                String currentPosition = String.valueOf(line.charAt(j));
                matrix[i][j] = currentPosition;
                if (currentPosition.equals("G")) {coordinates = new int[]{i, j};}
            }
        }
        int col = coordinates[0];
        int row = coordinates[1];

        while (!"end".equals(direction = scanner.nextLine())) {

            switch (direction) {
                case "up" -> col--;
                case "down" -> col++;
                case "left" -> row--;
                case "right" -> row++;
            }

            if (isValidPosition(col, row, side)) {
                String newPosition = matrix[col][row];

                switch (newPosition) {
                    case "W" ->   balance += 100;
                    case "P" -> { balance -= 200; if (balance <= 0) {isLooser = true;}}
                    case "J" -> { balance += 100000;                 isWinner = true;}
                }
                matrix[coordinates[0]][coordinates[1]] = "-";
                coordinates[0] = col;
                coordinates[1] = row;
                matrix[col][row] = "G";
            }

            if (isWinner) {
                System.out.println("You win the Jackpot!");
                break;
            } else if (isLooser) {
                System.out.println("Game over! You lost everything!");
                return;
            }
        }
        System.out.printf("End of the game. Total amount: %d$\n", balance);
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isValidPosition(int col, int row, int side) {
        return col >= 0 && col < side && row >= 0 && row < side;
    }
}

package ExamPrep.Exam1;

import java.util.Objects;
import java.util.Scanner;

public class T02EscapeTheMaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = String.valueOf(line.charAt(j));
            }
        }
        boolean hasEscaped = false;
        while (!hasEscaped) {
            String direction = scanner.nextLine();

            int[] currentPosition = findPosition(matrix, "P");
            int[] nextPosition = getNextPosition(currentPosition, direction);

            if (!isValidPosition(nextPosition, n)) {
                switch (matrix[nextPosition[0]][nextPosition[1]]) {
                    case "M" -> health -= 40;
                    case "H" -> health = Math.min(health + 15, 100);
                    case "X" -> hasEscaped = true;
                }
                matrix[currentPosition[0]][currentPosition[1]] = "-";
                matrix[nextPosition[0]][nextPosition[1]] = "P";

                if (health <= 0) {
                    health = 0;
                    System.out.println("Player is dead. Maze over!");
                    break;
                }
            }
        }

        if (hasEscaped) {
            System.out.println("Player escaped the maze. Danger passed!");
        }
        System.out.printf("Player's health: %d units\n", health);
        printMatrix(matrix);
    }

    private static boolean isValidPosition(int[] nextPosition, int n) {
        return nextPosition[0] < 0 || nextPosition[0] >= n || nextPosition[1] < 0 || nextPosition[1] >= n;
    }

    private static int[] findPosition(String[][] matrix, String element) {
        int[] position = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (Objects.equals(matrix[i][j], element)) {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }
        return position;
    }

    private static int[] getNextPosition(int[] currentPosition, String direction) {
        int[] nextPosition = currentPosition.clone();
        switch (direction) {
            case "up" -> nextPosition[0]--;
            case "down" -> nextPosition[0]++;
            case "left" -> nextPosition[1]--;
            case "right" -> nextPosition[1]++;
        }
        return nextPosition;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
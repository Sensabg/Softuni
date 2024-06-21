package ExamPrep.Exam4;

import java.util.Scanner;

public class T02FishingCompetition1 {
    private static int size;
    private static String command;
    private static int points;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        size = Integer.parseInt(scanner.nextLine());
        String[][] area = readMatrix(scanner, size);

        int[] coordinates = searchInMatrix(area, "S");
        int row = coordinates[0];
        int col = coordinates[1];

        while (!"collect the nets".equals(command = scanner.nextLine())) {
            switch (command) {
                case "up" -> row = (row - 1 + size) % size;
                case "down" -> row = (row + 1) % size;
                case "left" -> col = (col - 1 + size) % size;
                case "right" -> col = (col + 1) % size;
            }

            String newPosition = area[row][col];

            if ("W".equals(newPosition)) {
                System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]%n", row, col);
                return;
            } else {
                if (!"-".equals(newPosition)) {
                    points += Integer.parseInt(newPosition);
                }
                move(area, row, col, coordinates);
                coordinates[0] = row;
                coordinates[1] = col;
            }
        }

        if (points >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else {
            System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.%n", 20 - points);
        }

        if (points > 0) {
            System.out.printf("Amount of fish caught: %d tons.%n", points);
        }

        printMatrix(area);
    }

    private static void move(String[][] area, int row, int col, int[] coordinates) {
        area[row][col] = "S";
        area[coordinates[0]][coordinates[1]] = "-";
    }

    private static int[] searchInMatrix(String[][] matrix, String el) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals(el)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    private static String[][] readMatrix(Scanner scanner, int size) {
        String[][] matrix = new String[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().split("");
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            System.out.println(String.join("", row));
        }
    }
}
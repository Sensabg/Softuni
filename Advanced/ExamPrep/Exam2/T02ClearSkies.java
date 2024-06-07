package ExamPrep.Exam2;

import java.util.Scanner;

public class T02ClearSkies {
    private static int n;
    private static char[][] matrix;
    private static int jetfighterRow;
    private static int jetfighterCol;
    private static int armor = 300;
    private static int enemies = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());
        matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'J') {
                    jetfighterRow = i;
                    jetfighterCol = j;
                }
            }
        }

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            moveJetfighter(command);

            if (enemies == 0) {
                System.out.println("Mission accomplished, you neutralized the aerial threat!");
                break;
            }
            if (armor <= 0) {
                System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n", jetfighterRow, jetfighterCol);
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void moveJetfighter(String direction) {
        int newRow = jetfighterRow;
        int newCol = jetfighterCol;

        switch (direction) {
            case "up" -> newRow--;
            case "down" -> newRow++;
            case "left" -> newCol--;
            case "right" -> newCol++;
        }

        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
            char newPosition = matrix[newRow][newCol];

            switch (newPosition) {
                case 'E' -> {armor -= 100;enemies--;}
                case 'R' -> armor = Math.min(armor + 300, 300);
            }

            matrix[jetfighterRow][jetfighterCol] = '-';
            matrix[newRow][newCol] = 'J';

            jetfighterRow = newRow;
            jetfighterCol = newCol;
        }
    }
}
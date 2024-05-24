package MultidimensionalArrays.Ex;

import java.util.Arrays;
import java.util.Scanner;

public class T05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = readMatrix(scanner);
        String command;

        while (!"END".equals(command = readString(scanner))) {
            String[] positions = command.substring(5).split("\\s+");

            if (!"swap".equals(command.split("\\s+")[0]) || !isValidIndex(positions, matrix.length, matrix[0].length)) {
                System.out.println("Invalid input!");
            } else {
                int one = Integer.parseInt(positions[0]);
                int two = Integer.parseInt(positions[1]);
                int three = Integer.parseInt(positions[2]);
                int four = Integer.parseInt(positions[3]);
                String[] numbers = {matrix[one][two], matrix[three][four]};
                matrix[one][two] = numbers[1];
                matrix[three][four] = numbers[0];

                printMatrix(matrix);
            }
        }
    }

    private static boolean isValidIndex(String[] location, int rows, int cols) {
        int row1 = Integer.parseInt(location[0]);
        int col1 = Integer.parseInt(location[1]);
        int row2 = Integer.parseInt(location[2]);
        int col2 = Integer.parseInt(location[3]);

        return row1 >= 0 && row1 < rows && col1 >= 0 && col1 < cols &&
                row2 >= 0 && row2 < rows && col2 >= 0 && col2 < cols;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static String[][] readMatrix(Scanner scanner) {
        String[] dimensions = readString(scanner).split("\\s+");
        int row = Integer.parseInt(dimensions[0]);
        int col = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[row][col];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = readString(scanner).split("\\s+");
        }
        return matrix;
    }

    private static String readString(Scanner scanner) {
        return scanner.nextLine();
    }
}
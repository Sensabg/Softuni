package MultidimensionalArrays.Ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T07CrossfireNew {
    public static int startingPoint = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);
        List<List<Integer>> matrix = generateMatrix(dimensions);

        String command;
        while (!"Nuke it from orbit".equals(command = scanner.nextLine())) {
            int[] removeArea = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            removeElements(matrix, removeArea);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void removeElements(List<List<Integer>> matrix, int[] removeArea) {
        int row = removeArea[0];
        int col = removeArea[1];
        int range = removeArea[2];

        for (int currentRow = row - range; currentRow <= row + range; currentRow++) {
            if (isInMatrix(currentRow, col, matrix)) {
                matrix.get(currentRow).set(col, -1);
            }
        }

        for (int currentCol = col - range; currentCol <= col + range; currentCol++) {
            if (isInMatrix(row, currentCol, matrix)) {
                matrix.get(row).set(currentCol, -1);
            }
        }

        cleanMatrix(matrix);
    }

    private static boolean isInMatrix(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void cleanMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            row.removeIf(value -> value == -1);
        }
        matrix.removeIf(List::isEmpty);
    }

    private static List<List<Integer>> generateMatrix(int[] dimensions) {
        List<List<Integer>> matrix = new ArrayList<>();
        int number = startingPoint;
        for (int i = 0; i < dimensions[0]; i++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int j = 0; j < dimensions[1]; j++) {
                currentRow.add(number++);
            }
            matrix.add(currentRow);
        }
        return matrix;
    }

    public static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

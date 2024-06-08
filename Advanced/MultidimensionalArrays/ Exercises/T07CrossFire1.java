import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T07Crossfire {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);
        List<List<Integer>> matrix = generateMatrix(dimensions);

        String command;
        while (!(command = scanner.nextLine()).equals("Nuke it from orbit")) {
            String[] tokens = command.split("\\s+"); // 3 4 1
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            removeElements(matrix, row, col, radius);
            cleanMatrix(matrix);
        }

        printMatrix(matrix);
    }

    private static void removeElements(List<List<Integer>> matrix, int row, int col, int radius) {
        for (int currentRow = row - radius; currentRow <= row + radius; currentRow++) {
            if (isInMatrix(currentRow, col, matrix)) {
                matrix.get(currentRow).remove(col);
            }
        }

        for (int currentCol = col + radius; currentCol >= col - radius; currentCol--) {
            if (isInMatrix(row, currentCol, matrix)) {
                matrix.get(row).remove(currentCol);
            }
        }
    }

    private static boolean isInMatrix(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void cleanMatrix(List<List<Integer>> matrix) {
        matrix.removeIf(List::isEmpty);
    }

    private static List<List<Integer>> generateMatrix(int[] dimensions) {
        List<List<Integer>> matrix = new ArrayList<>();
        int number = 1;
        for (int row = 0; row < dimensions[0]; row++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int col = 0; col < dimensions[1]; col++) {
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

    public static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

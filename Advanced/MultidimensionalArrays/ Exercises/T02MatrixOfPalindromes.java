package MultidimensionalArrays.Ex;

import java.util.Arrays;
import java.util.Scanner;

public class T02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            char[] arr = updateChars(i);
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = String.valueOf(arr);
                arr[1]++;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static char[] updateChars(int i) {
        char[] arr = {'a', 'a', 'a'};
        arr[0] += i;
        arr[1] += i;
        arr[2] += i;
        return arr;
    }
}
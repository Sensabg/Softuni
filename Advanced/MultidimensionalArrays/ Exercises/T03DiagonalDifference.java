package MultidimensionalArrays.Ex;

import java.util.Arrays;
import java.util.Scanner;

public class T03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int[] sum = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            sum[0] += matrix[i][i];
            sum[1] += matrix[i][n - 1];
            n--;
        }
        System.out.println(Math.abs(sum[0] - sum[1]));
    }
}
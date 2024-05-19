package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class T01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areEqual = firstMatrix.length == secondMatrix.length;

        int i = 0;
        while (i < firstMatrix.length && areEqual) {
            int[] firstArray = firstMatrix[i];
            int[] secondArray = firstMatrix[i];

            areEqual = firstArray.length == secondArray.length;

            int j = 0;
            while(j < firstArray.length && areEqual){
                areEqual = firstArray[j] == secondArray[j];
                j++;
            }
            i++;
        }
        String output = areEqual ? "equal" : "not equal";
        System.out.println(output);
    }

    public static int[][] readMatrix(Scanner scanner) {

        int[] dimensions = readArray(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = readArray(scanner);
        }

        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

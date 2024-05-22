package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class T02PositionsOf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int number = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == number ){
                    System.out.println(i + " " + j);
                    isFound = true;
                }
            }
        }
        if(!isFound){
            System.out.println("not found");
        }
    }

    public static int[][] readMatrix(Scanner scanner) {

        int[] dimensions = readArray(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
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
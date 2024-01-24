package ArraysMoreExercise;

import java.util.Scanner;

public class PascalTriangle2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numRows = Integer.parseInt(scanner.nextLine());
        int[] triangle = new int[numRows * (numRows + 1) / 2];
        int index = 0;

        for (int row = 0; row < numRows; row++) {
            int currentValue = 1; // Initialize with the first element in each row

            for (int j = 0; j <= row; j++) {
                triangle[index++] = currentValue;
                currentValue = currentValue * (row - j) / (j + 1);
            }
        }
        // Display Pascal's Triangle
        int rowStart = 0;
        for (int row = 0; row < numRows; row++) {
            for (int j = rowStart; j < rowStart + row + 1; j++) {
                System.out.print(triangle[j] + " ");
            }
            System.out.println();
            rowStart += row + 1;
        }
    }
}
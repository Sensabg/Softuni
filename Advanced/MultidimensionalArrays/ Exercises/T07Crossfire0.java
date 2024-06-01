package MultidimensionalArrays.Ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T07Crossfire0 {
    public static int startingPoint = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);
        int[][] matrix = generateMatrix(dimensions);
        List<List<Integer>> modifiedMatrix = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            modifiedMatrix.add(new ArrayList<>());
            for (int j = 0; j < matrix[i].length; j++) {
                modifiedMatrix.get(i).add(matrix[i][j]);
            }
        }

        String command;
        while (!"Nuke it from orbit".equals(command = scanner.nextLine())) {
            int[] removeArea = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            removeElements(modifiedMatrix, removeArea);
        }
        printMatrix(modifiedMatrix);
    }

    private static void printMatrix(List<List<Integer>> modifiedMatrix) {
        System.out.println();
        for (int i = 0; i < modifiedMatrix.size(); i++) {
            for (int j = 0; j < modifiedMatrix.get(i).size(); j++) {
                if(modifiedMatrix.get(i).get(j) != -1) {
                    System.out.print(modifiedMatrix.get(i).get(j) + " ");
                }
            }
            System.out.println();
        }
    }


    private static void removeElements(List<List<Integer>> modifiedMatrix, int[] removeArea) {
        int col = removeArea[0];
        int row = removeArea[1];
        int range = removeArea[2];

        moveUp(col, row, range, modifiedMatrix);
        moveDown(col, row, range, modifiedMatrix);
        moveLeft(col, row, range, modifiedMatrix);
        moveRight(col, row, range, modifiedMatrix);
    }

    private static void moveRight(int start, int end, int range, List<List<Integer>> modifiedMatrix) {
        while (range >= 0 && end < modifiedMatrix.get(start).size()) {
            modifiedMatrix.get(start).remove(end);
            modifiedMatrix.get(start).add(-1);
            range--;
            end++;
        }
    }

    private static void moveLeft(int start, int end, int range, List<List<Integer>> modifiedMatrix) {
        while (range >= 0 && end >= 0) {
            modifiedMatrix.get(start).remove(end);
            modifiedMatrix.get(start).add(-1);
            range--;
            end--;
        }
    }

    private static void moveUp(int start, int end, int range, List<List<Integer>> modifiedMatrix) {
        while (range >= 0 && start >= 0) {
            modifiedMatrix.get(start).remove(end);
            modifiedMatrix.get(start).add(-1);
            range--;
            start--;
        }
    }

    private static void moveDown(int start, int end, int range, List<List<Integer>> modifiedMatrix) {
        while (range >= 0 && start < modifiedMatrix.size()) {
            modifiedMatrix.get(start).remove(end);
            modifiedMatrix.get(start).add(-1);
            range--;
            start++;
        }
    }

    private static int[][] generateMatrix(int[] dimensions) {
        int[][] matrix = new int[dimensions[0]][dimensions[1]];
        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                matrix[i][j] = startingPoint++;
            }
        }
        return matrix;
    }

    public static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}


//    private static int[] getRange(int side, int range, int[][] matrix) {
//        int start = Math.max(side - range, 0);
//        int end = Math.min(side + range, matrix.length - 1);
//        return new int[]{start, end};
//    }

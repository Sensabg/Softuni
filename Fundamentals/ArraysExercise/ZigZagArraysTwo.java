package ArraysExercise;

import java.util.Scanner;

public class ZigZagArraysTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String array1 = "";
        String array2 = "";

        for (int i = 0; i < n; i++) {
            int value1 = scanner.nextInt();
            int value2 = scanner.nextInt();

            if (i % 2 == 0) {
                array1 += value1 + " ";
                array2 += value2 + " ";
            } else {
                array1 += value2 + " ";
                array2 += value1 + " ";
            }
        }
        System.out.println(array1);
        System.out.println(array2);
    }
}

package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int [n];

        for (int i = 0; i < numbers.length; i++) {
            int values = Integer.parseInt(scanner.nextLine());
            numbers[i] += values;
        }

        for (int i = numbers.length - 1; i >= 0 ; i--) {
            System.out.printf("%d ",numbers[i]);
        }
    }
}

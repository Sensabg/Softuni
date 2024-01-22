package WhileLoopLab;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //int numbers = 0;
        int sum = 0;

        while (n > sum) {
          int numbers = Integer.parseInt(scanner.nextLine());

            sum += numbers;
        }
        System.out.println(sum);
    }
}

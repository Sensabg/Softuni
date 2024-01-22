package ForLoopLab;

import java.util.Scanner;

public class LeftandRightSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int rightSum = 0;
        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int digits = Integer.parseInt(scanner.nextLine());

            rightSum = rightSum + digits;

        }
        for (int i = 0; i < n; i++) {
            int digits = Integer.parseInt(scanner.nextLine());

            leftSum = leftSum + digits;

        }
        if (rightSum == leftSum) {
            System.out.printf("Yes, sum = %d", leftSum);
        } else {
            System.out.printf("No, diff = %d",Math.abs(leftSum - rightSum));
        }
    }
}

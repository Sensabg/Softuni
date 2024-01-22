package TestingOut;

import java.util.Scanner;

public class EvenOddSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x: ");
        int x = scanner.nextInt();

        int start = 0, end = 0;

        if (x % 2 == 0) {
            end = 2;
        } else {
            start = x;
            end = -2;
        }
        for (int i = start; i <= x; i += end) {
            if (i >= 0) {
                System.out.println(i);
            }
        }
    }
}

package ForLoopLab;

import java.util.Scanner;

public class EvenPowersof2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int a = 2;

        for (int i = 0; i <= n; i = i + 2) {
            double sum = Math.pow(a, i);
            System.out.printf("%.0f\n", sum);
        }
    }
}

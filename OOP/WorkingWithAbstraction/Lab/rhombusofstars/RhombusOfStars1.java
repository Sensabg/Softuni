package WorkingWithAbstraction.Lab.rhombusofstars;

import java.util.Scanner;

public class RhombusOfStars1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        printRhombus(n);
    }

    public static void printRhombus(int n) {
        printUpperHalf(n);
        printLowerHalf(n);
    }

    private static void printUpperHalf(int n) {
        for (int i = 0; i < n; i++) {
            printRepeatingString(" ", n - i - 1);
            printRepeatingString("* ", i + 1);
            System.out.println();
        }
    }

    private static void printLowerHalf(int n) {
        for (int i = n - 2; i >= 0; i--) {
            printRepeatingString(" ", n - i - 1);
            printRepeatingString("* ", i + 1);
            System.out.println();
        }
    }

    private static void printRepeatingString(String str, int repetitions) {
        for (int i = 0; i < repetitions; i++) {
            System.out.print(str);
        }
    }
}
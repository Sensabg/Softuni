package WorkingWithAbstraction.rhombusofstars;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        printTopPart(size);
        printBottomPart(size);

    }

    private static void printTopPart(int size) {
        for (int row = 1; row <= size; row++) {
            printSpaces(size - row);
            printStars(row);
            System.out.println();
        }
    }

    private static void printBottomPart(int size) {
        for (int row = 1; row < size; row++) {
            printSpaces(row);
            printStars(size - row);
            System.out.println();
        }
    }

    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static void printStars(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("* ");
        }
    }
}

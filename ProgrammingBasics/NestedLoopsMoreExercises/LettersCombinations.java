package NestedLoopsMoreExercises;

import java.util.Scanner;

public class LettersCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char start = scanner.next().charAt(0);
        char end = scanner.next().charAt(0);
        char skip = scanner.next().charAt(0);

        int combinationsCount = 0;
        StringBuilder result = new StringBuilder();

        for (char i = start; i <= end; i++) {
            for (char j = start; j <= end; j++) {
                for (char k = start; k <= end; k++) {
                    if (i != skip && j != skip && k != skip) {
                        result.append(i).append(j).append(k).append(" ");
                        combinationsCount++;
                    }
                }
            }
        }

        System.out.print(result);
        System.out.print(combinationsCount);
    }
}

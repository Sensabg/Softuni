package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class Kaminotest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthDNA = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        int lineCount = 0;
        int bestStartIndex = Integer.MAX_VALUE;
        int bestLineNum = 0;
        int bestOnes = 0;
        int bestSum = 0;

        int[] bestLine = null;

        while (!"Clone them!".equals(command)) {
            int[] currentLine = Arrays.stream(command.split("!+"))
                    .mapToInt(Integer::parseInt).toArray();

            lineCount++;
            int onesInARow = 0;
            int startIndex = Integer.MAX_VALUE;
            int sum = 0;

            for (int i = 0; i < lengthDNA; i++) {
                if (currentLine[i] == 1) {
                    onesInARow++;
                    if (onesInARow == 1) {
                        startIndex = i;
                    }
                } else {
                    onesInARow = 0;
                }
                sum += currentLine[i];
            }
            if (onesInARow > bestOnes
                    || (onesInARow == bestOnes && (startIndex < bestStartIndex
                    || (startIndex == bestStartIndex && sum > bestSum)))) {
                bestOnes = onesInARow;
                bestLineNum = lineCount;
                bestStartIndex = startIndex;
                bestSum = sum;
                bestLine = currentLine.clone();
            }
            command = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestLineNum, bestSum);
        System.out.println(Arrays.toString(bestLine).
                replace("[", "")
                .replace(",", "")
                .replace("]", ""));
    }
}
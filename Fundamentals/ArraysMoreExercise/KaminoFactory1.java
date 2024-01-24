package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        int bestSequenceSum = 0;
        int bestSequenceIndex = 0;
        int count = 0;
        int sequenceIndex = length;

        String input = scanner.nextLine();
        int[] dnaSequence = new int[length];
        while (!input.equals("Clone them!")) {

            int[] currentDNA = Arrays.stream(input.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int sum = 0;
            int index = length;
            count++;

            for (int i = 0; i < currentDNA.length; i++) {
                if ((i != currentDNA.length - 1)
                        && currentDNA[i] == 1
                        && currentDNA[i + 1] == 1
                        && index == length) {

                    index = i;
                }
                sum += currentDNA[i];
            }
            if (index == sequenceIndex && sum > bestSequenceSum) {

                dnaSequence = currentDNA;
                bestSequenceIndex = count;
                bestSequenceSum = sum;

            } else if (index < sequenceIndex) {

                dnaSequence = currentDNA;
                bestSequenceIndex = count;
                bestSequenceSum = sum;
                sequenceIndex = index;

            }
            input = scanner.nextLine();
        }
        if (bestSequenceSum == 0) {
            bestSequenceIndex = 1;
        }
        System.out.printf("Best DNA sample %d with sum: %d.\n", bestSequenceIndex, bestSequenceSum);
        System.out.println(Arrays.toString(dnaSequence).
                replace("[", "")
                .replace(",", "")
                .replace("]", ""));

    }
}
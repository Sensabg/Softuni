package ForLoopMoreExercises;

import java.util.Scanner;

public class OddOrEvenPosition {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double evenSum = 0;
        double oddSum = 0;

        double maxEven = Double.NEGATIVE_INFINITY;
        double maxOdd = Double.NEGATIVE_INFINITY;

        double minEven = Double.MAX_VALUE;
        double minOdd = Double.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            double numbers = Double.parseDouble(scanner.nextLine());

            if (i % 2 == 0) {
                evenSum += numbers;
                if (maxEven < numbers) {
                    maxEven = numbers;
                }
                if (minEven > numbers) {
                    minEven = numbers;
                }
            } else {
                oddSum += numbers;
                if (maxOdd < numbers) {
                    maxOdd = numbers;
                }
                if (minOdd > numbers) {
                    minOdd = numbers;
                }
            }
        }
        if (evenSum == minEven) {
            maxEven = minEven;
        }
        if (oddSum == minOdd) {
            maxOdd = minOdd;
        }

        if (evenSum == 0 && oddSum == 0) {
            System.out.printf("OddSum=%.2f,", oddSum);
            System.out.println("\nOddMin=No,");
            System.out.println("OddMax=No,");
            System.out.printf("EvenSum=%.2f,", evenSum);
            System.out.println("\nEvenMin=No,");
            System.out.println("EvenMax=No");
        } else if (evenSum == 0) {
            System.out.printf("OddSum=%.2f,", oddSum);
            System.out.printf("\nOddMin=%.2f,", minOdd);
            System.out.printf("\nOddMax=%.2f,", maxOdd);
            System.out.printf("\nEvenSum=%.2f,", evenSum);
            System.out.println("\nEvenMin=No,");
            System.out.println("EvenMax=No");
        } else if (oddSum == 0) {
            System.out.printf("\nOddSum=%.2f,", oddSum);
            System.out.println("OddMin=No,");
            System.out.println("OddMax=No,");
            System.out.printf("\nEvenSum=%.2f,", evenSum);
            System.out.printf("\nEvenMin=%.2f,", minEven);
            System.out.printf("\nEvenMax=%.2f", maxEven);
        } else {
            System.out.printf("\nOddSum=%.2f,", oddSum);
            System.out.printf("\nOddMin=%.2f,", minOdd);
            System.out.printf("\nOddMax=%.2f,", maxOdd);
            System.out.printf("\nEvenSum=%.2f,", evenSum);
            System.out.printf("\nEvenMin=%.2f,", minEven);
            System.out.printf("\nEvenMax=%.2f", maxEven);
        }
    }
}



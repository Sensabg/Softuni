package PBexamOne;

import java.util.Scanner;

public class BarcodeGenerator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int startRange = Integer.parseInt(scanner.nextLine());
        int endRange = Integer.parseInt(scanner.nextLine());

        int firstStart = startRange / 1000;
        int secondStart = (startRange / 100) % 10;
        int thirdStart = (startRange / 10) % 10;
        int fourthStart = startRange % 10;

        int firstEnd = endRange / 1000;
        int secondEnd = (endRange / 100) % 10;
        int thirdEnd = (endRange / 10) % 10;
        int fourthEnd = endRange % 10;

        for (int i = firstStart; i <= firstEnd; i++) {
            for (int j = secondStart; j <= secondEnd; j++) {
                for (int k = thirdStart; k <= thirdEnd; k++) {
                    for (int l = fourthStart; l <= fourthEnd; l++) {
                        if (i % 2 != 0 && j % 2 != 0 && k % 2 != 0 && l % 2 != 0) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                    }
                }
            }
        }
    }
}

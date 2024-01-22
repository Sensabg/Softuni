package PBexamOne;

import java.util.Scanner;

public class Barcode2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int startRange = Integer.parseInt(sc.nextLine());
        int endRange = Integer.parseInt(sc.nextLine());
        int currentNum;
        String currentString;
        boolean isInvalid;
        final String start = String.valueOf(startRange);
        final String end = String.valueOf(endRange);
        int startRangeCheck;
        int endRangeCheck;

        for (int i = startRange; i < endRange; i++) {

            currentString = String.valueOf(i);
            isInvalid = false;

            for (int j = 0; j < currentString.length(); j++) {

                currentNum = Integer.parseInt(String.valueOf(currentString.charAt(j)));
                startRangeCheck = Integer.parseInt(String.valueOf(start.charAt(j)));
                endRangeCheck = Integer.parseInt(String.valueOf(end.charAt(j)));

                if (startRangeCheck > currentNum || endRangeCheck < currentNum) {
                    isInvalid = true;
                    break;
                }

                if (currentNum == 0) {
                    isInvalid = true;
                    break;
                }

                if (currentNum % 2 == 0) {
                    isInvalid = true;
                    break;
                }
            }

            if (!isInvalid) {
                System.out.printf("%d ", i);
            }
        }
    }
}


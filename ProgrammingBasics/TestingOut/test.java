package TestingOut;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean cTaken = false;
        boolean oTaken = false;
        boolean nTaken = false;

        String input = "";
        String currentWord = "";
        String finalWord = "";

        while (!input.equals("End")) {
            input = sc.nextLine();

            char letter = input.charAt(0);

            if (!Character.isAlphabetic(letter)) {
                continue;
            }

            switch (letter) {
                case 'c':
                    if (!cTaken) {
                        cTaken = true;
                        continue;
                    }
                    break;
                case 'o':
                    if (!oTaken) {
                        oTaken = true;
                        continue;
                    }
                    break;
                case 'n':
                    if (!nTaken) {
                        nTaken = true;
                        continue;
                    }
                    break;
            }

            if (cTaken && oTaken && nTaken) {
                finalWord += currentWord + " ";
                cTaken = false;
                oTaken = false;
                nTaken = false;
                currentWord = "";
            }

            currentWord += letter;

        }
        System.out.println(finalWord);
    }
}
package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class TriplesOfLatinLetters2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    char firstLetter = alphabet.charAt(i);
                    char secondLetter = alphabet.charAt(j);
                    char thirdLetter = alphabet.charAt(k);

                    System.out.printf("%c%c%c%n", firstLetter, secondLetter, thirdLetter);
                }
            }
        }
    }
}



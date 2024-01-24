package DataTypesAndVariablesLab;

import java.util.Scanner;

public class ReversedChars2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] characters = new String[3];

        // Read characters
        for (int i = 0; i < 3; i++) {
            characters[i] = scanner.nextLine();
        }

        // Print characters in reversed order with a space between them
        for (int i = 2; i >= 0; i--) {
            System.out.print(characters[i] + " ");
        }
    }
}


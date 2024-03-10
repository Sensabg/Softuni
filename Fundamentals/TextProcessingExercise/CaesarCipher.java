package TextProcessingExercise;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();
        StringBuilder encryptedSentence = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            int currentSymbol = sentence.charAt(i);
            char encryptedSymbol = (char) (currentSymbol + 3);
//            char encryptedSymbol = (char) (sentence.charAt(i) + 3);
            encryptedSentence.append(encryptedSymbol);
        }
        System.out.println(encryptedSentence);
    }
}
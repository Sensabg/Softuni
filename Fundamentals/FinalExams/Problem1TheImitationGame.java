package FinalExams;

import java.util.Scanner;

public class Problem1TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        StringBuilder decryptMessage = new StringBuilder(encryptedMessage);
        String command;

        while (!"Decode".equals(command = scanner.nextLine())) {
            String[] input = command.split("\\|");
            String operation = input[0];

            switch (operation) {

                case "Move":
                    int amountOfLetters = Integer.parseInt(input[1]);
                    String takeChars = encryptedMessage.substring(0, amountOfLetters);
                    decryptMessage.replace(0, amountOfLetters, "").append(takeChars);
                    encryptedMessage = decryptMessage.toString();
                    break;

                case "Insert":
                    int index = Integer.parseInt(input[1]);
                    String value = input[2];
                    decryptMessage.insert(index, value);
                    encryptedMessage = decryptMessage.toString();
                    break;

                case "ChangeAll":
                    String substring = input[1];
                    String replacement = input[2];
                    encryptedMessage = encryptedMessage.replace(substring, replacement);
                    decryptMessage = new StringBuilder(encryptedMessage);
                    break;
            }
        }
        System.out.println("The decrypted message is: " + decryptMessage);
    }
}

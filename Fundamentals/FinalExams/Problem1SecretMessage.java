package FinalExams;

import java.util.Scanner;

public class Problem1SecretMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder secretMessage = new StringBuilder(scanner.nextLine());
        String input;

        while (!"Reveal".equals(input = scanner.nextLine())) {
            String[] info = input.split(":\\|:");
            String command = info[0];

            switch (command) {

                case "InsertSpace":
                    int index = Integer.parseInt(info[1]);
                    secretMessage.insert(index, " ");
                    System.out.println(secretMessage);
                    break;

                case "Reverse":
                    String substring = info[1];
                    String currentMessage = secretMessage.toString();
                    if (!currentMessage.contains(substring)) {
                        System.out.println("error");
                    } else {
                        StringBuilder reverseSubstring = new StringBuilder(substring).reverse();
                        secretMessage = new StringBuilder(currentMessage.replace(substring, ""));
                        secretMessage.append(reverseSubstring);
                        System.out.println(secretMessage);
                    }
                    break;

                case "ChangeAll":
                    String textToRemove = info[1];
                    String replacement = info[2];
                    String modify = secretMessage.toString();
                    secretMessage = new StringBuilder(modify.replaceAll(textToRemove, replacement));
                    System.out.println(secretMessage);
                    break;
            }
        }
        System.out.println("You have a new text message: " + secretMessage);
    }
}
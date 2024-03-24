package FinalExams;

import java.util.Scanner;

public class Problem1ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rawKey = scanner.nextLine();
        String input;
        int startIndex;
        int endIndex;

        while (!"Generate".equals(input = scanner.nextLine())) {
            String[] info = input.split(">>>");
            String command = info[0];

            switch (command) {

                case "Contains":
                    String substring = info[1];
                    if (!rawKey.contains(substring)) {
                        System.out.println("Substring not found!");
                    } else {
                        System.out.printf("%s contains %s\n", rawKey, substring);
                    }
                    break;

                case "Flip":
                    String direction = info[1];
                    startIndex = Integer.parseInt(info[2]);
                    endIndex = Integer.parseInt(info[3]);
                    String takeChars = rawKey.substring(startIndex, endIndex);

                    if (direction.equals("Upper")) {
                        rawKey = rawKey.replace(takeChars, takeChars.toUpperCase());
                    } else if (direction.equals("Lower")) {
                        rawKey = rawKey.replace(takeChars, takeChars.toLowerCase());
                    }
                    System.out.println(rawKey);
                    break;

                case "Slice":
                    startIndex = Integer.parseInt(info[1]);
                    endIndex = Integer.parseInt(info[2]);
                    String textToRemove = rawKey.substring(startIndex, endIndex);
                    rawKey = rawKey.replace(textToRemove,"");
                    System.out.println(rawKey);
                    break;
            }
        }
        System.out.println("Your activation key is: " + rawKey);
    }
}

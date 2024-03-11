package TextProcessingMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String randomString;
        while (!"find".equals(randomString = scanner.nextLine())) {
            StringBuilder decryptedMessage = new StringBuilder();

            for (int i = 0; i < randomString.length(); i++) {
                int currentChar = randomString.charAt(i);
                int keyIndex = i % numbers.length;
                int key = numbers[keyIndex];
                char decryptedChar = (char) (currentChar - key);
                decryptedMessage.append(decryptedChar);
            }
            String decryptedString = decryptedMessage.toString();
            String treasureType = findTreasureType(decryptedString);
            String coordinates = findCoordinates(decryptedString);

            System.out.println("Found " + treasureType + " at " + coordinates);

        }
    }

    private static String findTreasureType(String message) {
        int start = message.indexOf("&") + 1;
        int end = message.indexOf("&", start);
        return message.substring(start, end);
    }

    private static String findCoordinates(String message) {
        int start = message.indexOf("<") + 1;
        int end = message.indexOf(">", start);
        return message.substring(start, end);
    }
}
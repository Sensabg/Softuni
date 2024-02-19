package ListsMoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        StringBuilder message = new StringBuilder(scanner.nextLine());
        StringBuilder decryptedMessage = new StringBuilder();

        for (String getNumbers : numbers) {
            int number = Integer.parseInt(getNumbers);
            int getIndex = 0;

            while (number > 0) {
                getIndex += number % 10;
                number /= 10;
            }

            while (getIndex > message.length()) {
                getIndex -= message.length();
            }

            String getChar = String.valueOf(message.charAt(getIndex));
            decryptedMessage.append(getChar);
            message.deleteCharAt(getIndex);
        }
        System.out.println(decryptedMessage);
    }
}

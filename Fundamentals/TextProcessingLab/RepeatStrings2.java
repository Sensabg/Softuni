package TextProcessingLab;

import java.util.Arrays;
import java.util.Scanner;

public class RepeatStrings2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Arrays.stream(words)
                .forEach(word -> System.out.print(word.repeat(word.length())));
    }
}
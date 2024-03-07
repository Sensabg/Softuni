package TextProcessingLab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String words[] = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        for (String word : words) {
            String replacement = word.replace(word, "*".repeat(word.length()));
            text = text.replaceAll(word, replacement);
        }
        System.out.println(text);
    }
}

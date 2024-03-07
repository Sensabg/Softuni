package TextProcessingLab;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[]words =scanner.nextLine().split(" ");

        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                System.out.print(word);
            }
        }
    }
}
package TextProcessingLab;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;

        while (!"end".equals(word = scanner.nextLine())) {
            StringBuilder reverseWord = new StringBuilder(word).reverse();
            System.out.println(word + " = " + reverseWord);
        }
    }
}
package ArraysLab;

import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] letters = scanner.nextLine().split(" ");

        for (int i = 0; i < letters.length / 2; i++) {
            String oldElement = letters[i];
            letters[i] = letters[letters.length - 1 - i];
            letters[letters.length - 1 - i] = oldElement;

        }
        System.out.println(String.join(" ", letters));
    }
}

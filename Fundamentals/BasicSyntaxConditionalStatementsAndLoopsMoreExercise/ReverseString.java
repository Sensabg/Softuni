package BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        String reverse = "";
        int wordLength = word.length();

        for (int i = wordLength - 1; i >= 0 ; i--) {
            char rev = word.charAt(i);
            reverse+= ""+ rev;
        }
        System.out.println(reverse);
    }
}

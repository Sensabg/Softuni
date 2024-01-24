package DataTypesAndVariablesLab;

import java.util.Scanner;

public class ReversedCharacters3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = "";
        String reverse = "";

        for (int i = 1; i <= 3; i++) {
            String ch = scanner.nextLine();
            word += " "+ ch ;
            int length = word.length();
        }
        for (int j = word.length() - 1; j >= 0 ; j--) {
            char rev = word.charAt(j);
            reverse+=  rev;
        }
        System.out.println(reverse);
    }
}

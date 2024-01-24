package DataTypesAndVariablesLab;

import java.util.Scanner;

public class CharsToStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String finalS = "";

        for (int i = 0; i < 3; i++) {
            String ch = scanner.nextLine();

            finalS+= ch;
        }
        System.out.println(finalS);
    }
}

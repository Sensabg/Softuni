package DataTypesAndVariablesLab;

import java.util.Scanner;

public class ReverseChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String reversed = "";

        // Read characters and concatenate them in reverse order
        for (int i = 0; i < 3; i++) {
            String ch = scanner.nextLine();
            reversed = ch + " " + reversed;
        }

        // Print the reversed string
        System.out.println(reversed.trim());
    }
}

package TestingOut;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        char word;
        int finalWord = 0;

        if (key >= 0 && key <= 20 && n >= 0 && n <= 20){
            for (int i = 0; i < n; i++) {

                String input = scanner.nextLine();
                word = input.charAt(0);

                finalWord = word + key;
                System.out.print((char)finalWord);

            }
        }
    }
}

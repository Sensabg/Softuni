package ForLoopLab;

import java.util.Scanner;

public class VowelsSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        int a = 0;
        int sum = 0;

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);

            switch (letter) {
                case 'a':
                    a += 1; //a = a + 1
                    break;
                case 'e':
                    a += 2; //a = a + 2
                    break;
                case 'i':
                    a += 3; //a = a + 3
                    break;
                case 'o':
                    a += 4; //a = a + 4
                    break;
                case 'u':
                    a += 5; //a = a + 5
                    break;

            }
        }
        System.out.println(a);
    }
}

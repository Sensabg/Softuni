package TextProcessingLab;

import java.util.Scanner;

public class Substring2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String occurrence = scanner.nextLine();
        String text = scanner.nextLine();

        int index = text.indexOf(occurrence);

        while (index != -1) {

            text = text.replace(occurrence, "");
            index = text.indexOf(occurrence);
        }
        System.out.println(text);
    }
}

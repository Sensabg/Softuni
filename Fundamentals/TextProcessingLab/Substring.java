package TextProcessingLab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String text = scanner.nextLine();
        int index = text.indexOf(key);

        while (text.contains(key)) {

            text.replace(key,"");
        }
    }
}

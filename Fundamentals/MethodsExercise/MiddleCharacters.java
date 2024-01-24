package MethodsExercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println(middleCharacters(input));
    }

    public static String middleCharacters(String input) {
        String middle = "";
        if (input.length() % 2 == 0) {
            middle = String.valueOf(input.charAt((input.length()/ 2) - 1));
            middle += String.valueOf(input.charAt(input.length() / 2));
        } else {
            middle = String.valueOf(input.charAt(input.length() / 2));
        }
        return middle;
    }
}

package MethodsLab;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {
            case "string":
            case "String":
                String firstWord = scanner.nextLine();
                String secondWord = scanner.nextLine();
                System.out.println(getMaxString(firstWord, secondWord));
                break;
            case "int":
                int num1 = Integer.parseInt(scanner.nextLine());
                int num2 = Integer.parseInt(scanner.nextLine());
                System.out.println(getMaxInt(num1, num2));
                break;
            case "char":
                char firstLetter = scanner.nextLine().charAt(0);
                char secondLetter = scanner.nextLine().charAt(0);
                System.out.println(getMaxChar(firstLetter, secondLetter));
                break;
        }
    }

    public static String getMaxString(String firsWord, String secondWord) {
        if (firsWord.compareTo(secondWord) >= 0) {
            return firsWord;
        }
        return secondWord;
    }

    public static int getMaxInt(int num1, int num2) {

        return Math.max(num1, num2);
    }

    public static char getMaxChar(char firstLetter, char secondLetter) {
        if (firstLetter > secondLetter) {
            return firstLetter;
        }
        return secondLetter;
    }
}
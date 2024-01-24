package MethodsExercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            if (!isPalindrome(command)) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }

            command = scanner.nextLine();
        }

    }
    public static boolean isPalindrome(String num) {
        String newNum = "";
        String oldNum = num;
        boolean isPalindrome = false;
        while (Integer.parseInt(num) != 0) {
            newNum += Integer.parseInt(num) % 10;
            num = String.valueOf(Integer.parseInt(num) / 10);
        }
        if (newNum.equals(String.valueOf(oldNum))) {
            isPalindrome = true;
        }
        return isPalindrome;
    }
}
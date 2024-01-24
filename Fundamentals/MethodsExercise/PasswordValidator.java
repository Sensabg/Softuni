package MethodsExercise;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if(!isInRange(password)){
            System.out.println("Password must be between 6 and 10 characters");
        }

        if(!containsOnlyDigitsAndLetters(password)){
            System.out.println("Password must consist only of letters and digits");
        }

        if(!contains2Digits(password)){
            System.out.println("Password must have at least 2 digits");
        }

        if(isInRange(password) && containsOnlyDigitsAndLetters(password) && contains2Digits(password)){
            System.out.println("Password is valid");
        }
    }

    public static boolean isInRange(String password) {
        boolean isInRange = false;
        if (password.length() >= 6 && password.length() <= 12) {
            isInRange = true;
        }
        return isInRange;
    }

    public static boolean containsOnlyDigitsAndLetters(String password) {
        boolean isValid = false;
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            if ((currentChar >= 48 && currentChar <= 57)
                    || (currentChar >= 65 && currentChar <= 90)
                    || (currentChar >= 97 && currentChar <= 122)){
                isValid = true;
            } else {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
    public static boolean contains2Digits(String password){
        String numbers = "1234567890";
        boolean atLeastTwoDigits = false;
        int counter = 0;
        for (int i = 0; i < password.length() ; i++) {
            if(numbers.contains(String.valueOf(password.charAt(i)))){
                counter++;
            }
        }
        if(counter >= 2){
            atLeastTwoDigits = true;
        }
        return atLeastTwoDigits;
    }
}
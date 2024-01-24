package MethodsExercise;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        System.out.println(amountOfVowels(word));
    }
    public static String amountOfVowels(String word){
        String vowels = "AOUEIaouei";
        int counter = 0;
        for (int i = 0; i < word.length() ; i++) {
            if(vowels.contains(String.valueOf(word.charAt(i)))){
                counter++;
            }
        }
        return String.valueOf(counter);
    }
}
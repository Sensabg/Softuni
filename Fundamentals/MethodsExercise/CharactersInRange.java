package MethodsExercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);

        characterInBetween(first,second);
    }
    public static void  characterInBetween(char first, char second){
        if(first< second) {
            for (int i = first + 1; i < second; i++) {
                System.out.print((char) i + " ");
            }
        } else {
            for (int i = second + 1; i < first; i++) {
                System.out.print((char) i + " ");
            }
        }
    }
}

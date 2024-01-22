package WhileLoopMoreExercises;

import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean foundN = false;
        boolean foundO = false;
        boolean foundC = false;

        String word = "";
        StringBuilder currentWord = new StringBuilder();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            if (Character.isLetter(input.charAt(0))) {
                if (input.equals("n") && !foundN) {
                    foundN = true;
                } else if (input.equals("o") && !foundO) {
                    foundO = true;
                } else if (input.equals("c") && !foundC) {
                    foundC = true;
                } else {
                    currentWord.append(input);
                }

                if (foundN && foundO && foundC) {
                    word += currentWord.toString() + " ";
                    foundN = false;
                    foundO = false;
                    foundC = false;
                    currentWord.setLength(0);
                }
            }

            input = scanner.nextLine();
        }

        System.out.println(word.trim());
    }
}

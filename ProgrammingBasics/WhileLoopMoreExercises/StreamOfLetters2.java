package WhileLoopMoreExercises;

import java.util.Scanner;

public class StreamOfLetters2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String cleanedInput = input.replaceAll("[^a-zA-Z]", "");
        String word = "";
        String finalWord = "";

        boolean isFoundN = false;
        boolean isFoundC = false;
        boolean isFoundO = false;

        while (!input.equals("End")) {
            cleanedInput = input.replaceAll("[^a-zA-Z]", "");

            switch(cleanedInput){
                case"c":
                    if(!isFoundC) {
                        isFoundC = true;
                        cleanedInput="";
                    }
                    break;
                case"o":
                    if(!isFoundO) {
                        isFoundO = true;
                        cleanedInput="";
                    }

                    break;
                case"n":
                    if(!isFoundN) {
                        isFoundN = true;
                        cleanedInput="";
                    }
                    break;
            }
            if (isFoundN && isFoundO && isFoundC) {
                finalWord += word + " ";
                isFoundN = false;
                isFoundO = false;
                isFoundC = false;
                word = "";
            }

            word +=cleanedInput;

            input = scanner.nextLine();
        }
        System.out.println(finalWord);
    }
}

package ObjectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] wordsArr = scanner.nextLine().split(" ");

        for (int i = 0; i < wordsArr.length; i++) {
            int randomIndexOne = random.nextInt(wordsArr.length);
            int randomIndexTwo = random.nextInt(wordsArr.length);

            String oldWord = wordsArr[randomIndexOne];

            wordsArr[randomIndexOne] = wordsArr[randomIndexTwo];
            wordsArr[randomIndexTwo] = oldWord;
        }

        System.out.println(String.join(System.lineSeparator(), wordsArr));
    }
}
package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int magicNum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                if(currentNum + numbers[j] == magicNum){
                    System.out.println(currentNum + " " + numbers[j] + " ");
                }
            }

        }
    }
}

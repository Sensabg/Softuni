import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int biggestNum = 0;
        int foundAtIndex = -1;

        for (int i = 1; i < numbers.length; i++) {
            int currentNum = numbers[i];
            if (currentNum > biggestNum) {
                biggestNum = currentNum;
                foundAtIndex = i;
            }
        }

        for (int i = foundAtIndex; i < numbers.length - 1; i++) {
            int currentNum = numbers[i];
            boolean isBigger = false;

            for (int j = i + 1; j <= numbers.length - 1; j++) {
                int compareNum = numbers[j];
                if (currentNum <= compareNum) {
                    isBigger = true;
                    break;
                }
            }
            
            if (!isBigger) {
                System.out.print(currentNum + " ");
            }
        }
        System.out.println(numbers[numbers.length - 1]);
    }
}

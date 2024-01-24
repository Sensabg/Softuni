package ArraysExercise;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine());
        String[] stringArray = new String[numbers];
        int[] newArr = new int[numbers];
        int sum = 0;

        for (int i = 0; i <= numbers - 1; i++) {
            newArr[i] += Integer.parseInt(scanner.nextLine());
            sum += newArr[i];
            stringArray[i] = String.valueOf(newArr[i]);

            if (i == newArr.length - 1) {
                System.out.println(String.join(" ", stringArray));
                System.out.println(sum);
            }
        }
    }
}
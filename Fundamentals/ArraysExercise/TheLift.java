package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleWaiting = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int counter = 0;
        boolean full = false;
        int peopleLeft = peopleWaiting;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 4 && numbers[i] + peopleLeft <= 4 && peopleLeft > 0) {
                numbers[i] += peopleLeft;
                peopleLeft = peopleLeft - peopleWaiting;
            } else if (peopleLeft > 0) {
                numbers[i] += 4;
                peopleLeft -= 4;
            }
            if (numbers[i] > 4) {
                int peopleAllowed = numbers[i] - 4;
                numbers[i] -= peopleAllowed;
                peopleLeft = peopleLeft + peopleAllowed;
            }
            if (numbers[i] == 4) {
                counter++;
                if (counter == numbers.length) {
                    full = true;
                }
            }
            if (full && peopleLeft > 0) {
                System.out.printf("There isn't enough space! %d people in a queue!\n", peopleLeft);
            } else if (i == numbers.length - 1 && !full) {
                System.out.println("The lift has empty spots!");
            }
        }
        System.out.println(Arrays.toString(numbers).
                replace("[", "").
                replace(", ", " ").
                replace("]", ""));
    }
}
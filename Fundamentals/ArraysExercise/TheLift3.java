package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleWaiting = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] < 4 && peopleWaiting > 0) {
                numbers[i]++;
                peopleWaiting--;
            }
        }
        boolean isFull = Arrays.stream(numbers).allMatch(capacity -> capacity == 4);

        if (peopleWaiting == 0 && !isFull) {
            System.out.println("The lift has empty spots!");
        } else {
            System.out.printf("There isn't enough space! %d people in a queue!\n", peopleWaiting);
        }
        System.out.println(Arrays.toString(numbers).replace("[", "")
                .replace(", ", " ").replace("]", ""));
    }
}
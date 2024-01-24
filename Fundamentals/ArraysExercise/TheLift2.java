package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleWaiting = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int peopleLeft = peopleWaiting;
        boolean full = false;
        int counter = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 4) {
                int load = Math.min(4 - numbers[i], peopleLeft);
                numbers[i] += load;
                peopleLeft -= load;
                if (numbers[i] == 4 && ++counter == numbers.length) {
                    full = true;
                }
            }
        }
        if (full && peopleLeft > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!\n",peopleLeft);
        } else if (!full) {
            System.out.println("The lift has empty spots!");
        }
        System.out.println(Arrays.toString(numbers).replace("[","")
                .replace(", "," ").replace("]",""));
    }
}
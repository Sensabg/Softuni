package WhileLoopMoreExercises;

import java.util.Scanner;

public class NumbersDividedByThreeWithoutReminder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        while (counter < 100) {
            counter++;

            if (counter % 3 == 0) {
                System.out.println(counter);
            }
        }

    }
}

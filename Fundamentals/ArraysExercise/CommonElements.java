package ArraysExercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringArrOne = scanner.nextLine().split(" ");
        String[] stringArrTwo = scanner.nextLine().split(" ");

        for (String element : stringArrTwo) {
            for (int i = 0; i < stringArrOne.length; i++) {
                if (element.equals(stringArrOne[i])) {
                    System.out.print(element + " ");
                }
            }
        }
    }
}

package WhileLoopLab;

import java.util.Scanner;

public class Sequence2kPlus1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startingNumber = 1;
        int number = Integer.parseInt(scanner.nextLine());
        while (startingNumber <= number) {

            System.out.println(startingNumber);

            startingNumber = 2 * startingNumber + 1;
        }


    }
}

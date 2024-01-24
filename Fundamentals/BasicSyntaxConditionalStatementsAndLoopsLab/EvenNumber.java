package BasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int current = 0;

        while (n % 2 != 0) {
            current = n;
            System.out.println("Please write an even number.");

            n = Integer.parseInt(scanner.nextLine());
        }
        System.out.printf("The number is: %d",Math.abs(n));

    }
}

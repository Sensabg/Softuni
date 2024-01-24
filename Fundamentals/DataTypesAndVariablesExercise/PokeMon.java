package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());

        int halfValue =  n * 50 / 100;

        int counter = 0;

        while (n >= m) {

            if (n == halfValue) {
                n = n / y;
            } else {
                n = n - m;
                counter++;
            }
        }
            System.out.println(n);
            System.out.println(counter);
    }
}

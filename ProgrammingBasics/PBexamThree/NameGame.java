package PBexamThree;

import java.util.Scanner;

public class NameGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String winner = "";
        int points = 0;
        int maxPoints = 0;

        while (!"Stop".equals(command)) {
            String name = command;
            int n = name.length();
            for (int i = 0; i < n; i++) {
                int number = Integer.parseInt(scanner.nextLine());
                int ascii = name.charAt(i);
                if (ascii == number) {
                    points += 10;
                } else {
                    points += 2;
                }

            }

            if (maxPoints <= points) {
                winner = name;
                maxPoints = points;
            }
            points = 0;
            command = scanner.nextLine();
        }
        System.out.printf("The winner is %s with %d points!", winner, maxPoints);
    }
}

package NestedLoopsLab;

import java.util.Scanner;

public class Building {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int floor = Integer.parseInt(scanner.nextLine());
        int room = Integer.parseInt(scanner.nextLine());

        for (int i = floor; i > 0; i--) {
            for (int j = 0; j < room; j++) {
                if (i == floor) {
                    System.out.printf("L%d%d",i,j);
                    System.out.print(" ");
                } else if (i % 2 == 0){
                    System.out.printf("O%d%d",i,j);
                    System.out.print(" ");
                } else {
                    System.out.printf("A%d%d",i,j);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

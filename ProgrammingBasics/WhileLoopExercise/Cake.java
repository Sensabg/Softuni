package WhileLoopExercise;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());

        int cakeTotalSize = length * width;
        //int sumCakes = 0;
        boolean cakeFinished = false;
        String input = scanner.nextLine();
        while (!input.equals("STOP")) {

            int cakes = Integer.parseInt(input);

            cakeTotalSize -= cakes;

            if (cakeTotalSize <= 0) {
                cakeFinished = true;
                break;
            }

            input = scanner.nextLine();
        }

        if(cakeFinished){
            System.out.printf("No more cake left! You need %d pieces more.",Math.abs(cakeTotalSize));
        } else {
            System.out.printf("%d pieces are left.",cakeTotalSize);
        }
    }
}

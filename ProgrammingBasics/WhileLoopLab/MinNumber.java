package WhileLoopLab;

import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String stop = scanner.nextLine();

        int minNumber = Integer.MAX_VALUE;

        while (!stop.equals("Stop")) {
            int numbers = Integer.parseInt(stop);

            if(numbers < minNumber){
                minNumber = numbers;
            }

            stop = scanner.nextLine();
        }
        System.out.println(minNumber);
    }
}


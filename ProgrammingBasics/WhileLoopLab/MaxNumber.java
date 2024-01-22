package WhileLoopLab;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String stop = scanner.nextLine();

        int maxNumber = Integer.MIN_VALUE;

        while (!stop.equals("Stop")) {
            int numbers = Integer.parseInt(stop);

            if(numbers > maxNumber){
                maxNumber = numbers;
            }

            stop = scanner.nextLine();
        }
        System.out.println(maxNumber);
    }
}

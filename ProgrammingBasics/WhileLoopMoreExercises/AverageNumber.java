package WhileLoopMoreExercises;

import java.util.Scanner;

public class AverageNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        double sum = 0;

        while(n>counter){
            counter++;
            int num = Integer.parseInt(scanner.nextLine());

            sum+=num;

        }

        double average = sum / n;
        System.out.printf("%.2f",average);
    }
}

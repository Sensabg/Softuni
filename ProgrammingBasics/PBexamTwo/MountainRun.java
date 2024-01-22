package PBexamTwo;

import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timeFramePerSecond = Double.parseDouble(scanner.nextLine());

        double timeFrame = distance * timeFramePerSecond;
        double slowDown = Math.floor((distance / 50)) * 30;

        double totalTime = timeFrame + slowDown;

        if (totalTime < record){
            System.out.printf("Yes! The new record is %.2f seconds.",totalTime);
        } else {
            System.out.printf("No! He was %.2f seconds slower.",Math.abs(record - totalTime));
        }
    }
}

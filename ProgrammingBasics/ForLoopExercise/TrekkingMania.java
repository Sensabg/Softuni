package ForLoopExercise;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int groupAmount = Integer.parseInt(scanner.nextLine());

        int musala = 0;
        int monblan = 0;
        int kilimandjaro = 0;
        int k2 = 0;
        int everest = 0;


        int totalPeople = 0;

        for (int i = 0; i < groupAmount; i++) {
            int peopleAmount = Integer.parseInt(scanner.nextLine());

            totalPeople = totalPeople + peopleAmount;

            if (peopleAmount <= 5) {
                musala += peopleAmount;
            } else if (peopleAmount <= 12) {
                monblan += peopleAmount;
            } else if (peopleAmount <= 25) {
                kilimandjaro += peopleAmount;
            } else if (peopleAmount <= 40) {
                k2 += peopleAmount;
            } else if (peopleAmount >= 41) {
                everest += peopleAmount;
            }
        }
        System.out.printf("%.2f%%\n", musala / (totalPeople * 1.0) * 100);
        System.out.printf("%.2f%%\n", monblan / (totalPeople * 1.0) * 100);
        System.out.printf("%.2f%%\n", kilimandjaro / (totalPeople * 1.0) * 100);
        System.out.printf("%.2f%%\n", k2 / (totalPeople * 1.0) * 100);
        System.out.printf("%.2f%%\n", everest / (totalPeople * 1.0) * 100);
    }
}

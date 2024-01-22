package WhileLoopExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double moneyForVacation = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());

        int daySpend = 0;
        int totalDays = 0;

        while (true) {
            String saveOrSpend = scanner.nextLine();
            double money = Double.parseDouble(scanner.nextLine());

            totalDays++;

            if (saveOrSpend.equals("save")) {
                availableMoney += money;
                daySpend = 0;
                if (availableMoney >= moneyForVacation) {
                    System.out.printf("You saved the money for %d days.", totalDays);
                    break;
                }
            } else if(saveOrSpend.equals("spend")) {
                daySpend++;
                availableMoney -= money;
                if (availableMoney <= 0) {
                    availableMoney = 0;
                }
                if (daySpend == 5) {
                    System.out.println("You can't save the money.");
                    System.out.printf("%d", totalDays);
                    break;
                }
            }
        }
    }
}

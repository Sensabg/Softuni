package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentMoney = Double.parseDouble(scanner.nextLine());
        int studentsAmount = Integer.parseInt(scanner.nextLine());
        double pricePerLightSabers = Double.parseDouble(scanner.nextLine());
        double pricePerRobes = Double.parseDouble(scanner.nextLine());
        double pricePerBelt = Double.parseDouble(scanner.nextLine());

        int counter = 0;

        double totalPriceLightSabers = (pricePerLightSabers * Math.ceil((studentsAmount * 0.10)))
                + (pricePerLightSabers * studentsAmount);
        double totalPriceRobes = (pricePerRobes * studentsAmount);

        for (int i = 1; i <= studentsAmount; i++) {
            if (i % 6 == 0) {
                counter++;
            }
        }

        double totalPriceBelts = (pricePerBelt * studentsAmount)  - counter * pricePerBelt;
        double totalPrice = totalPriceBelts + totalPriceRobes + totalPriceLightSabers;

        if (currentMoney >= totalPrice) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalPrice - currentMoney);
        }
    }
}

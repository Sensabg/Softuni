package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int overnightAmount = Integer.parseInt(scanner.nextLine());

        double apartment = 0;
        double studio = 0;

        switch (month) {
            case "May":
            case "October":
                studio = 50 * overnightAmount;
                apartment = 65 * overnightAmount;
            if (overnightAmount > 7 && overnightAmount < 14){
                studio = studio - ( studio * 0.05);
            } else if (overnightAmount > 14) {
                studio = studio - ( studio * 0.30);
            }
                break;
            case "June":
            case "September":
                studio = 75.20 * overnightAmount;
                apartment = 68.70 * overnightAmount;
                if (overnightAmount > 14) {
                    studio = studio - (studio * 0.20);
                }
                break;
            case "July":
            case "August":
                studio = 76 * overnightAmount;
                apartment = 77 * overnightAmount;
                break;

            }
        if (overnightAmount > 14) {
            apartment = apartment - (apartment * 0.10);
        }

        System.out.printf("Apartment: %.2f lv.",apartment);
        System.out.printf("\nStudio: %.2f lv.", studio);
    }
}

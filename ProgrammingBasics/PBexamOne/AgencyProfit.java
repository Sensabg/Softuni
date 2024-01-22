package PBexamOne;

import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String airlineName = scanner.nextLine();
        int ticketAdultAmount = Integer.parseInt(scanner.nextLine());
        int ticketKidAmount = Integer.parseInt(scanner.nextLine());
        double ticketAdultPrice = Double.parseDouble(scanner.nextLine());
        double tax = Double.parseDouble(scanner.nextLine());

        double ticketAdultFinalPrice = ticketAdultPrice + tax;
        double ticketKidFinalPrice = (ticketAdultPrice * 0.30) + tax;

        double ticketTotalPrice = (ticketAdultAmount * ticketAdultFinalPrice) + (ticketKidAmount * ticketKidFinalPrice);
        double airlineProfit = ticketTotalPrice * 0.20;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", airlineName, airlineProfit);

    }
}

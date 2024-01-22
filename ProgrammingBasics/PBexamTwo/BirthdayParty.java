package PBexamTwo;

import java.util.Scanner;

public class BirthdayParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rentRoomPrice = Double.parseDouble(scanner.nextLine());

        double cakePrice = rentRoomPrice * 0.20;
        double drinksPrice = cakePrice - (cakePrice * 0.45);
        double animatorPrice = rentRoomPrice / 3;

        double totalPrice = rentRoomPrice + cakePrice + drinksPrice + animatorPrice;

        System.out.printf("%.1f", totalPrice);
    }
}

package PBexamThree;

import java.util.Scanner;

public class TravelAgency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        String equipmentType = scanner.nextLine();
        String VIP = scanner.nextLine();
        int amountOfDays = Integer.parseInt(scanner.nextLine());

        double price = 0;

        if(amountOfDays <= 0){
            System.out.println("Days must be positive number!");
            return;
        }

        switch (city) {
            case "Bansko":
            case "Borovets":
                switch (equipmentType) {
                    case "noEquipment":
                        price = 80;
                        if(VIP.equals("yes")){
                            price = price - (price * 0.05);
                        }
                        break;
                    case "withEquipment":
                        price = 100;
                        if(VIP.equals("yes")){
                            price = price - (price * 0.10);
                        }
                        break;
                }
                break;
            case "Varna":
            case "Burgas":
                switch (equipmentType) {
                    case "noBreakfast":
                        price = 100;
                        if(VIP.equals("yes")){
                            price = price - (price * 0.07);
                        }
                        break;
                    case "withBreakfast":
                        price = 130;
                        if(VIP.equals("yes")){
                            price = price - (price * 0.12);
                        }
                        break;
                }
        }
        double totalPrice = price * amountOfDays;

        if(amountOfDays > 7){
            totalPrice = totalPrice - price;
        }

        if(totalPrice <= 0){
            System.out.println("Invalid input!");
            return;
        }

        System.out.printf("The price is %.2flv! Have a nice time!",totalPrice);

    }
}

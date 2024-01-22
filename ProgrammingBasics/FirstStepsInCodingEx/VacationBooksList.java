package FirstStepsInCodingEx;

import java.util.Scanner;

public class VacationBooksList {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int bookPages = Integer.parseInt(scanner.nextLine());
        int readPages = Integer.parseInt(scanner.nextLine());
        int amountDays = Integer.parseInt(scanner.nextLine());

        int timeNeeded = bookPages / readPages;
        int totalTimeNeeded = timeNeeded / amountDays;

        System.out.println(totalTimeNeeded);

    }
}

package cards2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardRank[] rank = CardRank.values();

        System.out.println("Card Ranks:");
        for (CardRank cardRank : rank) {
            int ordinal = cardRank.ordinal();
            System.out.printf("Ordinal value: %d; Name value: %s\n", ordinal, cardRank);
        }
    }
}

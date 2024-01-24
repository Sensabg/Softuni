package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int headsetCounter = 0;
        int mouseCounter = 0;
        int keyboardCounter = 0;
        int displayCounter = 0;

        for (int i = 1; i <= lostGames; i++) {
            if (i % 2 == 0) {
                headsetCounter++;
            }
            if (i % 3 == 0) {
                mouseCounter++;
            }
            if (i % 2 == 0 && i % 3 == 0) {
                keyboardCounter++;
            }
            if (i % 12 == 0) {
                displayCounter++;
            }
        }
        double headsetTotalPrice = headsetPrice * headsetCounter;
        double mouseTotalPrice = mousePrice * mouseCounter;
        double keyboardTotalPrice = keyboardPrice * keyboardCounter;
        double totalDisplayPrice = displayPrice * displayCounter;

        double rageExpenses = headsetTotalPrice + mouseTotalPrice + keyboardTotalPrice + totalDisplayPrice;

        System.out.printf("Rage expenses: %.2f lv.", rageExpenses);
    }
}

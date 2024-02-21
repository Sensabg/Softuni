package ListsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double money = Double.parseDouble(scanner.nextLine());
        List<Integer> initialDrumPadsDurability = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> damagedDrumPads = new ArrayList<>(initialDrumPadsDurability);

        String command = scanner.nextLine();
        while (!"Hit it again, Gabsy!".equals(command)) {
            int damagePerDay = Integer.parseInt(command);

            for (int i = 0; i < damagedDrumPads.size(); i++) {
                int initialHealth = initialDrumPadsDurability.get(i);
                int currentHealth = damagedDrumPads.get(i);
                int priceForDrumPad = initialHealth * 3;

                if (currentHealth <= 0 && money - priceForDrumPad <= 0) {
                    damagedDrumPads.remove(damagedDrumPads.get(i));
                    initialDrumPadsDurability.remove(initialDrumPadsDurability.get(i));
                } else {
                    currentHealth -= damagePerDay;
                    damagedDrumPads.set(i, currentHealth);
                }

                if (money - priceForDrumPad >= 0 && currentHealth <= 0) {
                    money -= priceForDrumPad;
                    damagedDrumPads.set(i, initialHealth);
                }
            }

            command = scanner.nextLine();
        }
        System.out.println(damagedDrumPads.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.", money);

    }
}

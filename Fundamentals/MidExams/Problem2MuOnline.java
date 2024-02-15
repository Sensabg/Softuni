package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem2MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> rooms = Arrays
                .stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        int health = 100;
        int coins = 0;
        int countRooms = 0;

        for (int i = 0; i < rooms.size(); i++) {
            int value = Integer.parseInt((rooms.get(i).split(" ")[1]));
            String room = rooms.get(i).split(" ")[0];
            countRooms++;

            if (room.contains("potion")) {
                if (value + health > 100) {
                    System.out.printf("You healed for %d hp.\n", 100 - health);
                    health = 100;
                    System.out.printf("Current health: %d hp.\n", health);
                } else {
                    health += value;
                    System.out.printf("You healed for %d hp.\n",value);
                    System.out.printf("Current health: %d hp.\n",health);
                }
            } else if (room.contains("chest")) {
                coins += value;
                System.out.printf("You found %d bitcoins.\n", value);
            } else {
                if (health > 0 && health - value > 0) {
                    health -= value;
                    System.out.printf("You slayed %s.\n", room);
                } else {
                    System.out.printf("You died! Killed by %s.\n", room);
                    System.out.printf("Best room: %d\n", countRooms);
                    return;
                }
            }
        }
        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d\nHealth: %d",coins,health);
    }
}
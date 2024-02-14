package MidExams;

import java.util.*;
import java.util.stream.Collectors;

public class Problem3Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inventory = Arrays
                .stream(scanner.nextLine().split(",\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!"Craft!".equals(command)) {
            switch (command.split(" ")[0]) {
                case "Collect":
                    String collectItem = (command.split(" ")[2]);
                    inventory.removeAll(Collections.singleton(collectItem));
                    inventory.add(collectItem);
                    break;
                case "Drop":
                    String dropItem = (command.split(" ")[2]);
                    inventory.remove(dropItem);
                    break;
                case "Combine":
                    String getItems = (command.split(" ")[3]);
                    String oldItem = (getItems.split(":")[0]);
                    String newItem = (command.split(":")[1]);

                    for (String existingItems : inventory) {
                        if (existingItems.equals(oldItem)) {
                            int index = inventory.indexOf(oldItem);
                            inventory.add(index + 1, newItem);
                            break;
                        }
                    }
                    break;
                case "Renew":
                    String renewItem = (command.split(" ")[2]);

                    for (String existingItems : inventory) {
                        if (existingItems.equals(renewItem)) {
                            inventory.remove(renewItem);
                            inventory.add(renewItem);
                            break;
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(inventory.toString().replaceAll("[\\[\\]]", ""));
    }
}
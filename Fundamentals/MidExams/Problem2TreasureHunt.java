package MidExams;

import java.util.*;
import java.util.stream.Collectors;

public class Problem2TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listOfItems = Arrays
                .stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!"Yohoho!".equals(command)) {

            List<String> resultList = Arrays.asList(command.split("\\s+"));

            switch (command.split(" ")[0]) {
                case "Loot":
                    for (int i = 1; i < resultList.size(); i++) {
                        String currentElement = resultList.get(i);
                        if (!listOfItems.contains(currentElement)) {
                            listOfItems.add(0, currentElement);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(command.split(" ")[1]);
                    if (index >= 0 && index <= listOfItems.size() - 1) {
                        String currentElement = listOfItems.get(index);
                        listOfItems.remove(index);
                        listOfItems.add(currentElement);
                    }
                    break;
                case "Steal":
                    int removeLastItems = Integer.parseInt(command.split(" ")[1]);
                    List<String> removedItems = new ArrayList<>();

                    if (removeLastItems > listOfItems.size()) {
                        removeLastItems = listOfItems.size();
                    }
                    for (int i = 0; i < removeLastItems; i++) {
                        removedItems.add(listOfItems.get(listOfItems.size() - 1 - i));
                    }
                    listOfItems.removeAll(removedItems);
                    Collections.reverse(removedItems);
                    System.out.println(removedItems.toString().replaceAll("[\\[\\]]", ""));
                    break;
            }
            command = scanner.nextLine();
        }
        if (listOfItems.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double sum = 0;
            for (int i = 0; i < listOfItems.size(); i++) {
                String getItem = listOfItems.get(i);
                sum += getItem.length();
            }
            sum = sum / listOfItems.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", sum);
        }
    }
}
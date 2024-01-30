package ListsExercise;

import java.util.*;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int amountOfCommands = Integer.parseInt(scanner.nextLine());
        List<String> guestList = new ArrayList<>();

        for (int i = 0; i < amountOfCommands; i++) {
            String command = scanner.nextLine();
            String isGoing = command.split(" ")[2];
            String name = command.split(" ")[0];

            if (!isGoing.equals("not") && !guestList.contains(name)) {
                guestList.add(name);
            } else if (!isGoing.equals("not") && guestList.contains(name)) {
                System.out.printf("%s is already in the list!", name);
                System.out.println();
            } else if (isGoing.equals("not") && !guestList.contains(name)) {
                System.out.printf("%s is not in the list!", name);
                System.out.println();
            } else if (isGoing.equals("not") && guestList.contains(name)) {
                guestList.remove(name);
            }
        }
        for (String s : guestList) {
            System.out.println(s);
        }
    }
}
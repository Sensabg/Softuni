package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem3Manowar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> warShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxHealth = Integer.parseInt(scanner.nextLine());
        int pirateShipSize = pirateShip.size();
        int warShipSize = warShip.size();

        String command = scanner.nextLine();
        while (!"Retire".equals(command)) {
            switch (command.split(" ")[0]) {
                case "Fire":
                    attackTheWarShip(warShip, command);
                    break;
                case "Defend":
                    attackThePirateShip(pirateShip, command);
                    break;
                case "Repair":
                    repairThePirateShip(pirateShip, command, maxHealth);
                    break;
                case "Status":
                    printTheStatusOfEachSection(pirateShip, maxHealth);
                    break;
            }
            command = scanner.nextLine();
        }
        if(pirateShipSize == pirateShip.size() && warShipSize == warShip.size()){
            System.out.printf("Pirate ship status: %d\n", pirateShip.stream().mapToInt(Integer::intValue).sum());
            System.out.printf("Warship status: %d", warShip.stream().mapToInt(Integer::intValue).sum());
        }
    }

    private static void printTheStatusOfEachSection(List<Integer> pirateShip,int maxHealth) {

        int counter = 0;
        for (int i = 0; i < pirateShip.size() ; i++) {
            if(pirateShip.get(i) < 0.20 * maxHealth){
                counter++;
            }
        }
        System.out.printf("%d sections need repair.\n",counter);
    }

    private static boolean isValidIndex(List<Integer> pirateShip, int index) {
        if (index >= 0 && index <= pirateShip.size() - 1) {
            return true;
        }
        return false;
    }

    private static List<Integer> repairThePirateShip(List<Integer> pirateShip, String command, int maxHealth) {
        int index = Integer.parseInt(command.split(" ")[1]);
        int health = Integer.parseInt(command.split(" ")[2]);

        if (isValidIndex(pirateShip, index)) {
            int healSection = pirateShip.get(index);
            healSection += health;
            if (healSection > maxHealth) {
                healSection = maxHealth;
            }
            pirateShip.set(index, healSection);
        }
        return pirateShip;
    }

    private static List<Integer> attackThePirateShip(List<Integer> pirateShip, String command) {
        int startIndex = Integer.parseInt(command.split(" ")[1]);
        int endIndex = Integer.parseInt(command.split(" ")[2]);
        int damage = Integer.parseInt(command.split(" ")[3]);

        if (startIndex >= 0 && startIndex <= pirateShip.size() - 1
                && endIndex >= 0 && endIndex <= pirateShip.size() - 1) {

            for (int i = startIndex; i <= endIndex; i++) {
                int currentSection = pirateShip.get(i);
                currentSection -= damage;
                if (currentSection > 0) {
                    pirateShip.set(i, currentSection);
                } else {
                    System.out.println("You lost! The pirate ship has sunken.");
                    pirateShip.remove(i);
                    return pirateShip;
                }
            }
        }
        return pirateShip;
    }

    private static List<Integer> attackTheWarShip(List<Integer> warShip, String command) {
        int index = Integer.parseInt(command.split(" ")[1]);
        int damage = Integer.parseInt(command.split(" ")[2]);

        if (isValidIndex(warShip, index)) {
            int section = warShip.get(index);
            section -= damage;
            if (section > 0) {
                warShip.set(index, section);
            } else {
                System.out.println("You won! The enemy ship has sunken.");
                warShip.remove(index);
                return warShip;
            }
        }
        return warShip;
    }
}

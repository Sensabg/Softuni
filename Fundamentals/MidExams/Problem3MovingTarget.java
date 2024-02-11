package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem3MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfIntegersTargets = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!"End".equals(command)) {

            switch (command.split(" ")[0]) {
                case "Shoot":
                    shootATarget(listOfIntegersTargets, command);
                    break;
                case "Add":
                    addMoreTargets(listOfIntegersTargets, command);
                    break;
                case "Strike":
                    strikeTheTargets(listOfIntegersTargets, command);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(listOfIntegersTargets.toString().replace("[", "")
                .replace(", ", "|")
                .replace("]", ""));
    }

    private static List<Integer> strikeTheTargets(List<Integer> listOfIntegersTargets, String command) {
        int index = Integer.parseInt(command.split(" ")[1]);
        int radius = Integer.parseInt(command.split(" ")[2]);

        if (radius + index > listOfIntegersTargets.size() - 1 || index - radius < 0) {
            System.out.println("Strike missed!");
            return listOfIntegersTargets;
        } else {
            for (int i = index + 1; i <= index + radius; i++) {
                listOfIntegersTargets.remove(listOfIntegersTargets.get(i));
            }
            for (int i = index; i >= index - radius; i--) {
                listOfIntegersTargets.remove(listOfIntegersTargets.get(i));
            }
        }
        return listOfIntegersTargets;
    }

    private static List<Integer> addMoreTargets(List<Integer> listOfIntegersTargets, String command) {
        int index = Integer.parseInt(command.split(" ")[1]);
        int value = Integer.parseInt(command.split(" ")[2]);

        if (index >= 0 && index < listOfIntegersTargets.size()) {
            listOfIntegersTargets.add(index, value);
        } else {
            System.out.println("Invalid placement!");
        }
        return listOfIntegersTargets;
    }

    private static List<Integer> shootATarget(List<Integer> listOfIntegersTargets, String command) {
        int index = Integer.parseInt(command.split(" ")[1]);
        int power = Integer.parseInt(command.split(" ")[2]);

        if (index < 0 || index > listOfIntegersTargets.size() - 1) {
            return listOfIntegersTargets;
        }

        listOfIntegersTargets.set(index, listOfIntegersTargets.get(index) - power);

        if (listOfIntegersTargets.get(index) <= 0) {
            listOfIntegersTargets.remove(index);
        }

        return listOfIntegersTargets;
    }
}
package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int wagonsCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String addWagons = command.split(" ")[0];

            if (addWagons.equals("Add")) {
                wagons.add(Integer.parseInt(command.split(" ")[1]));
            } else {
                int passengersOnQue = Integer.parseInt(command);
                for (int i = 0; i < wagons.size(); i++) {
                    int currentPassengers = wagons.get(i);
                    if (passengersOnQue + currentPassengers <= wagonsCapacity) {
                        wagons.set(i, passengersOnQue + currentPassengers);
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
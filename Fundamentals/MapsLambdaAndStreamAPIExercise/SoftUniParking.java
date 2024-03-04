package MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> carOwners = new LinkedHashMap<>();
        int numberOfActions = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfActions; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String command = data[0];
            String clientName = data[1];

            switch (command) {
                case "register":
                    String plateNumber = data[2];
                    if (carOwners.containsKey(clientName)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", plateNumber);
                    } else {
                        carOwners.put(clientName, plateNumber);
                        System.out.printf("%s registered %s successfully%n", clientName, plateNumber);
                    }
                    break;
                case "unregister":
                    if (!carOwners.containsKey(clientName)) {
                        System.out.println(String.format("ERROR: user %s not found", clientName));
                    } else {
                        carOwners.remove(clientName);
                        System.out.println(String.format("%s unregistered successfully", clientName));
                    }
                    break;
            }
        }
        carOwners.entrySet().forEach(entry ->
                System.out.printf("%s => %s\n", entry.getKey(), entry.getValue()));
    }
}
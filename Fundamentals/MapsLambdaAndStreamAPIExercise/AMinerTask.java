package MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (resources.containsKey(input)) {
                int existingQuantity = resources.get(input);
                resources.put(input, existingQuantity + quantity);
            } else {
                resources.put(input, quantity);
            }
            input = scanner.nextLine();
        }
        resources.forEach((key, value) ->
                System.out.printf("%s -> %d%n", key, value));
    }
}
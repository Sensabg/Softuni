package MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            resources.merge(input, quantity, Integer::sum);

            input = scanner.nextLine();
        }
        resources.forEach((key, value) ->
                System.out.printf("%s -> %d%n", key, value));
    }
}
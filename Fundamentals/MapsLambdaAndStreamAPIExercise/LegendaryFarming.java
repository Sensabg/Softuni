package MapsLambdaAndStreamAPIExercise;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new LinkedHashMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        Map<String, Integer> junks = new LinkedHashMap<>();

        boolean isLegendaryItemBought = false;

        while (!isLegendaryItemBought) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            for (int i = 0; i < tokens.length; i+=2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    int existingQuantity = materials.get(material);
                    materials.put(material, existingQuantity + quantity);
                } else {
                    if (junks.containsKey(material)) {
                        int existingQuantity = junks.get(material);
                        junks.put(material, existingQuantity + quantity);
                    } else {
                        junks.put(material, quantity);
                    }
                }
                for (Map.Entry<String, Integer> entry : materials.entrySet()) {

                    if (entry.getValue() >= 250) {
                        if (entry.getKey().equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else if (entry.getKey().equals("fragments")) {
                            System.out.println("Valanyr obtained!");
                        } else if (entry.getKey().equals("motes")) {
                            System.out.println("Dragonwrath obtained!");
                        }
                        int newQuantity = entry.getValue() - 250;
                        materials.put(material, newQuantity);
                        isLegendaryItemBought = true;
                        break;
                    }
                }
                if (isLegendaryItemBought) {
                    break;
                }
            }
        }
        materials.entrySet().stream()
                .forEach(entry -> System.out.printf("%s: %d\n", entry.getKey(), entry.getValue()));
        junks.entrySet().forEach(entry -> System.out.printf("%s: %d\n", entry.getKey(), entry.getValue()));
    }
}
package AssociativeArraysLambdaAndStreamAPI;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, ArrayList<String>> words = new LinkedHashMap<>();
        int iterations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < iterations; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonym);
        }
        words.entrySet().stream()
                .forEach(entry -> {
                    String word = entry.getKey();
                    String synonyms = String.join(", ", entry.getValue());
                    System.out.println(word + " - " + synonyms);
                });
    }
}
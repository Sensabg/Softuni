package AssociativeArraysLambdaAndStreamAPI;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> wordCountMap = new LinkedHashMap<>();
        String[] words = scanner.nextLine().split("\\s+");

        for (String word : words) {
            String lowercaseWord = word.toLowerCase();
            wordCountMap.put(lowercaseWord, wordCountMap.getOrDefault(lowercaseWord, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                result.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", result));
    }
}
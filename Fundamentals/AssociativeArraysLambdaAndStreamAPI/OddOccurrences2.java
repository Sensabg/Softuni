package AssociativeArraysLambdaAndStreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class OddOccurrences2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Map<String, Long> wordCountMap = Arrays.stream(words)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(w -> w, LinkedHashMap::new, Collectors.counting()));

        Set<String> result = wordCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println(String.join(", ", result));
    }
}
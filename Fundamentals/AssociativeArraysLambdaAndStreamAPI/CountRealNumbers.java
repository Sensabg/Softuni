package AssociativeArraysLambdaAndStreamAPI;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Map<Double, Integer> numberCountMap = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));

        numberCountMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.printf("%.0f -> %d\n", entry.getKey(), entry.getValue()));
    }
}
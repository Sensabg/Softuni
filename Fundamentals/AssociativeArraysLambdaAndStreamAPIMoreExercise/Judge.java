package AssociativeArraysLambdaAndStreamAPIMoreExercise;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> usersData = new TreeMap<>();
        String input;

        while (!(input = scanner.nextLine()).equals("no more time")) {
            String[] inputData = input.split(" -> ");
            String student = inputData[0];
            String course = inputData[1];
            int points = Integer.parseInt(inputData[2]);

            usersData.computeIfAbsent(course, k -> new TreeMap<>())
                    .put(student, points);
        }
        AtomicInteger iteration = new AtomicInteger(1);

        Comparator<Map.Entry<String, Map<String, Integer>>> courseComparator =
                Comparator.<Map.Entry<String, Map<String, Integer>>>comparingInt(entry -> entry.getValue().size())
                        .reversed();

        usersData.entrySet().stream()
                .sorted(courseComparator)
                .forEach(courseEntry -> {
                    String course = courseEntry.getKey();
                    Map<String, Integer> points = courseEntry.getValue();
                    iteration.set(1);

                    System.out.printf("%s: %d participants\n", course, points.size());

                    points.entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .forEach(e -> System.out.printf("%d. %s <::> %d\n", iteration.getAndIncrement(), e.getKey(), e.getValue()));
                });
        iteration.set(1);
        System.out.println("Individual standings:");
        Map<String, Integer> totalPoints = usersData.entrySet().stream()
                .flatMap(entry -> entry.getValue().entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.summingInt(Map.Entry::getValue)));

        totalPoints.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> System.out.printf("%d. %s -> %d\n", iteration.getAndIncrement(), e.getKey(), e.getValue()));
    }
}
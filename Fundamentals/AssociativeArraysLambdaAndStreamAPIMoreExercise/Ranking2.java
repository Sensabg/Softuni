package AssociativeArraysLambdaAndStreamAPIMoreExercise;

import java.util.*;

public class Ranking2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> subjectDetails = new TreeMap<>();
        Map<String, Map<String, Integer>> usersPoints = new TreeMap<>();

        getLoginData(scanner, subjectDetails);
        validateData(scanner, subjectDetails, usersPoints);
        printResults(usersPoints);
    }

    private static void getLoginData(Scanner scanner, Map<String, String> subjectDetails) {
        String input;
        while (!(input = scanner.nextLine()).equals("end of contests")) {
            String[] courseInfo = input.split(":");
            String course = courseInfo[0];
            String pass = courseInfo[1];
            subjectDetails.put(course, pass);
        }
    }

    private static void validateData(Scanner scanner, Map<String, String> subjectDetails,
                                        Map<String, Map<String, Integer>> usersPoints) {
        String input;
        while (!(input = scanner.nextLine()).equals("end of submissions")) {
            String[] usersInfo = input.split("=>");
            String course = usersInfo[0];
            String pass = usersInfo[1];
            String user = usersInfo[2];
            int points = Integer.parseInt(usersInfo[3]);

            boolean isValidData = subjectDetails.containsKey(course) && subjectDetails.get(course).equals(pass);

            if (isValidData) {
                usersPoints.computeIfAbsent(user, k -> new TreeMap<>());
                usersPoints.get(user).merge(course, points, Integer::max);
            }
        }
    }

    private static void printResults(Map<String, Map<String, Integer>> usersPoints) {
        String bestCandidate = "";
        int maxPoints = Integer.MIN_VALUE;

        for (Map.Entry<String, Map<String, Integer>> entry : usersPoints.entrySet()) {
            String user = entry.getKey();
            Map<String, Integer> points = entry.getValue();
            int totalPoints = points.values().stream().mapToInt(Integer::intValue).sum();

            if (totalPoints > maxPoints) {
                maxPoints = totalPoints;
                bestCandidate = user;
            }
        }
        System.out.printf("Best candidate is %s with total %d points.\n", bestCandidate, maxPoints);
        System.out.println("Ranking:");
        usersPoints.entrySet().forEach(entry -> {
            String user = entry.getKey();
            Map<String, Integer> points = entry.getValue();

            System.out.println(user);
            points.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(e -> System.out.printf("#  %s -> %d\n", e.getKey(), e.getValue()));
        });
    }
}
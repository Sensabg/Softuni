package AssociativeArraysLambdaAndStreamAPIMoreExercise;

import java.util.*;

public class MOBA2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> players = new LinkedHashMap<>();
        String input;

        while (!"Season end".equals(input = scanner.nextLine())) {
            if (input.contains("->")) {
                handlePlayerInput(input, players);
            } else {
                handleVersusInput(input, players);
            }
        }
        printResults(players);
    }

    private static void handlePlayerInput(String input, Map<String, Map<String, Integer>> players) {
        String[] info = input.split(" -> ");
        String username = info[0];
        String position = info[1];
        int points = Integer.parseInt(info[2]);

        players.computeIfAbsent(username, k -> new HashMap<>()).put(position, points);
    }

    private static void handleVersusInput(String input, Map<String, Map<String, Integer>> players) {
        String[] users = input.split(" vs ");
        String playerOne = users[0];
        String playerTwo = users[1];

        if (players.containsKey(playerOne) && players.containsKey(playerTwo)) {
            compareAndRemove(players, playerOne, playerTwo);
        }
    }

    private static void compareAndRemove(Map<String, Map<String, Integer>> players, String playerOne, String playerTwo) {
        Map<String, Integer> positionsPlayerOne = players.get(playerOne);
        Map<String, Integer> positionsPlayerTwo = players.get(playerTwo);

        Set<String> sharedPositions = new HashSet<>(positionsPlayerOne.keySet());
        sharedPositions.retainAll(positionsPlayerTwo.keySet());

        if (!sharedPositions.isEmpty()) {
            String sharedPosition = sharedPositions.iterator().next();

            int pointsPlayerOne = positionsPlayerOne.getOrDefault(sharedPosition, 0);
            int pointsPlayerTwo = positionsPlayerTwo.getOrDefault(sharedPosition, 0);

            if (pointsPlayerOne < pointsPlayerTwo) {
                players.remove(playerOne);
            } else if (pointsPlayerOne > pointsPlayerTwo) {
                players.remove(playerTwo);
            }
        }
    }

    private static void printResults(Map<String, Map<String, Integer>> players) {
        players.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, Map<String, Integer>>>comparingInt(entry ->
                                entry.getValue().values().stream().mapToInt(Integer::intValue).sum())
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
                .forEach(entry -> {
                    System.out.printf("%s: %d skill\n", entry.getKey(),
                            entry.getValue().values().stream().mapToInt(Integer::intValue).sum());

                    entry.getValue().entrySet().stream()
                            .sorted(Comparator.<Map.Entry<String, Integer>>comparingInt(e -> e.getValue())
                                    .reversed()
                                    .thenComparing(Map.Entry::getKey))
                            .forEach(position ->
                                    System.out.printf("- %s <::> %d\n", position.getKey(), position.getValue()));
                });
    }
}
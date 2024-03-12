package AssociativeArraysLambdaAndStreamAPIMoreExercise;

import java.util.*;

public class MOBA2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> players = new LinkedHashMap<>();
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

    private static void handlePlayerInput(String input, Map<String, LinkedHashMap<String, Integer>> players) {
        String[] info = input.split(" -> ");
        String username = info[0];
        String position = info[1];
        int points = Integer.parseInt(info[2]);

        players.computeIfAbsent(username, k -> new LinkedHashMap<>());

        LinkedHashMap<String, Integer> rolesAndPoints = players.get(username);
        if (!rolesAndPoints.containsKey(position) || points > rolesAndPoints.get(position)) {
            rolesAndPoints.put(position, points);
        }
    }

    private static void handleVersusInput(String input, Map<String, LinkedHashMap<String, Integer>> players) {
        String[] users = input.split(" vs ");
        String playerOne = users[0];
        String playerTwo = users[1];

        if (players.containsKey(playerOne) && players.containsKey(playerTwo)) {
            for (Map.Entry<String, Integer> entry : players.get(playerOne).entrySet()) {
                String role = entry.getKey();
                int player1Points = entry.getValue();

                if (players.get(playerTwo).containsKey(role)) {
                    int player2Points = players.get(playerTwo).get(role);

                    if (player1Points < player2Points) {
                        players.remove(playerOne);
                        break;
                    } else if (player1Points > player2Points) {
                        players.remove(playerTwo);
                        break;
                    }
                }
            }
        }
    }

    private static void printResults(Map<String, LinkedHashMap<String, Integer>> players) {
        players.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, LinkedHashMap<String, Integer>>>comparingInt(entry ->
                                entry.getValue().values().stream().mapToInt(Integer::intValue).sum())
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
                .forEach(entry -> {
                    System.out.printf("%s: %d skill\n", entry.getKey(),
                            entry.getValue().values().stream().mapToInt(Integer::intValue).sum());

                    entry.getValue().entrySet().stream()
                            .sorted(Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                                    .reversed()
                                    .thenComparing(Map.Entry::getKey))
                            .forEach(position ->
                                    System.out.printf("- %s <::> %d\n", position.getKey(), position.getValue()));
                });
    }
}

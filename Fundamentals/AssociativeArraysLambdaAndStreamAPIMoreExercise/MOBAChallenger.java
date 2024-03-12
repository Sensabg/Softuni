80/100
package AssociativeArraysLambdaAndStreamAPIMoreExercise;

import java.util.*;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<PlayerPosition>> players = new LinkedHashMap<>();
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

    private static void handlePlayerInput(String input, Map<String, List<PlayerPosition>> players) {
        String[] info = input.split(" -> ");
        String username = info[0];
        String position = info[1];
        int points = Integer.parseInt(info[2]);

        players.computeIfAbsent(username, k -> new ArrayList<>()).add(new PlayerPosition(position, points));
    }

    private static void handleVersusInput(String input, Map<String, List<PlayerPosition>> players) {
        String[] users = input.split(" vs ");
        String playerOne = users[0];
        String playerTwo = users[1];

        if (players.containsKey(playerOne) && players.containsKey(playerTwo)) {
            compareAndRemove(players, playerOne, playerTwo);
        }
    }

    private static void compareAndRemove(Map<String, List<PlayerPosition>> players, String playerOne, String playerTwo) {
        List<PlayerPosition> positionsPlayerOne = players.get(playerOne);
        List<PlayerPosition> positionsPlayerTwo = players.get(playerTwo);

        Set<String> sharedPositions = new HashSet<>();

        for (PlayerPosition playerPosition : positionsPlayerOne) {
            if (positionsPlayerTwo.stream().anyMatch(p -> p.getPosition().equals(playerPosition.getPosition()))) {
                sharedPositions.add(playerPosition.getPosition());
                break;
            }
        }
        if (!sharedPositions.isEmpty()) {
            String sharedPosition = sharedPositions.iterator().next();

            int pointsPlayerOne = getPointsForPosition(positionsPlayerOne, sharedPosition);
            int pointsPlayerTwo = getPointsForPosition(positionsPlayerTwo, sharedPosition);

            if (pointsPlayerOne < pointsPlayerTwo) {
                players.remove(playerOne);
            } else if (pointsPlayerOne > pointsPlayerTwo) {
                players.remove(playerTwo);
            }
        }
    }

    private static int getPointsForPosition(List<PlayerPosition> playerPositions, String position) {
        return playerPositions.stream()
                .filter(playerPosition -> playerPosition.getPosition().equals(position))
                .mapToInt(PlayerPosition::getPoints)
                .findFirst()
                .orElse(0);
    }

    private static int calculateTotalPoints(List<PlayerPosition> playerPositions) {
        return playerPositions.stream().mapToInt(PlayerPosition::getPoints).sum();
    }

    private static void printResults(Map<String, List<PlayerPosition>> players) {
        players.entrySet().stream()
                .sorted(Comparator.comparingInt((Map.Entry<String, List<PlayerPosition>> entry) ->
                                calculateTotalPoints(entry.getValue()))
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
                .forEach(entry -> {
                    System.out.printf("%s: %d skill\n", entry.getKey(), calculateTotalPoints(entry.getValue()));

                    entry.getValue().stream()
                            .sorted(Comparator.comparingInt(PlayerPosition::getPoints)
                                    .reversed()
                                    .thenComparing(PlayerPosition::getPosition))
                            .forEach(playerPosition ->
                                    System.out.printf("- %s <::> %d\n", playerPosition.getPosition(), playerPosition.getPoints()));
                });
    }
    static class PlayerPosition {
        private String position;
        private int points;

        public PlayerPosition(String position, int points) {
            this.position = position;
            this.points = points;
        }

        public String getPosition() {
            return position;
        }

        public int getPoints() {
            return points;
        }
    }
}

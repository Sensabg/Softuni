import java.util.*;

public class slavun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> teams = new LinkedHashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("Lumpawaroo")) {

            if (input.contains("|")) {
                String[] parts = input.split(" \\| ");
                String teamName = parts[0];
                String playerName = parts[1];

                teams.putIfAbsent(teamName, new ArrayList<>());

                boolean playerExists = teams.values().stream()
                        .anyMatch(team -> team.contains(playerName));

                if (!playerExists) {
                    teams.get(teamName).add(playerName);
                }

            } else if (input.contains("->")) {
                String[] parts = input.split(" -> ");
                String playerName = parts[0];
                String teamName = parts[1];

                teams.values().forEach(team -> team.remove(playerName));
                teams.putIfAbsent(teamName, new ArrayList<>());
                teams.get(teamName).add(playerName);

                System.out.printf("%s joins the %s side!%n", playerName, teamName);
            }
        }


        for (Map.Entry<String, List<String>> entry : teams.entrySet()) {
            String teamName = entry.getKey();
            List<String> players = entry.getValue();

            if (!players.isEmpty()) {
                System.out.printf("Side: %s, Members: %d%n", teamName, players.size());
                for (String player : players) {
                    System.out.println("! " + player);
                }
            }
        }
    }
}
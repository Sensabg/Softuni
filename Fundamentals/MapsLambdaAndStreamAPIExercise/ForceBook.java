package MapsLambdaAndStreamAPIExercise;

import java.util.*;
import java.util.stream.Collectors;

public class ForceBook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> teams = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")) {

            if (input.contains("|")) {
                String teamName = input.split(" \\| ")[0];
                String playerName = input.split(" \\| ")[1];

                if (!teams.containsKey(teamName)) {
                    teams.put(teamName, new ArrayList<>());
                }

                boolean isPlayerExisting = false;
                for (List<String> team : teams.values()) {
                    if (team.contains(playerName)) {
                        isPlayerExisting = true;
                        break;
                    }
                }
                if (!isPlayerExisting) {
                    teams.get(teamName).add(playerName);
                }
            } else if (input.contains("->")) {
                String playerName = input.split(" -> ")[0];
                String teamName = input.split(" -> ")[1];

                for (List<String> team : teams.values()) {
                    team.remove(playerName);
                }

                if (teams.containsKey(teamName)) {
                    teams.get(teamName).add(playerName);
                } else {
                    teams.put(teamName, new ArrayList<>());
                    teams.get(teamName).add(playerName);
                }
                System.out.printf("%s joins the %s side!%n", playerName, teamName);
            }
            input = scanner.nextLine();
        }
        teams.entrySet().stream()
                .filter(entry ->
                        !entry.getValue().isEmpty())
                .forEach(entry -> System.out.printf("Side: %s, Members: %d\n! %s\n", entry.getKey(),
                        entry.getValue().size(),
                        entry.getValue().stream().map(String::valueOf).collect(Collectors.joining("\n! "))));
    }
}
//        for (Map.Entry<String, List<String>> entry : teams.entrySet()) {
//            String teamName = entry.getKey();
//            List<String> players = entry.getValue();
//
//            if (players.size() > 0) {
//                System.out.println("Side: " + teamName + ", Members: " + players.size());
//                players.forEach(player -> System.out.println("! " + player));
//            }
//        }
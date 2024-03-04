package AssociativeArraysLambdaAndStreamAPIMoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> contestsParticipants = new LinkedHashMap<>();
        String input;

        while (!"no more time".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(" -> ");
            String username = tokens[0];
            String course = tokens[1];
            int userPoints = Integer.parseInt(tokens[2]);

            contestsParticipants.putIfAbsent(course, new HashMap<>());
            contestsParticipants.get(course)
                    .compute(username, (user, oldPoints) ->
                            (oldPoints == null || oldPoints < userPoints) ? userPoints : oldPoints);
        }

        Comparator<Map.Entry<String, Integer>> participantsComparator = Map.Entry.<String, Integer>
                        comparingByValue(Comparator.reverseOrder())
                .thenComparing(Map.Entry.comparingByKey());

        contestsParticipants.forEach((contest, participants) -> {
            System.out.printf("%s: %d participants\n", contest, participants.size());
            final int[] index = {0};
            participants.entrySet()
                    .stream()
                    .sorted(participantsComparator)
                    .forEach(participant -> {
                        System.out.printf("%d. %s <::> %d%n",
                                ++index[0], participant.getKey(), participant.getValue());
                    });
        });
        System.out.println("Individual standings:");
        final int[] index = {0};
        contestsParticipants.values()
                .stream()
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)))
                .entrySet()
                .stream()
                .sorted(participantsComparator)
                .forEach(participant -> {
                    System.out.printf("%d. %s -> %d%n", ++index[0], participant.getKey(), participant.getValue());
                });
    }
}

package T01StacksQueues.Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class T10Robotics4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("(?<robot>[A-Z]+[0-9]*?)-(?<duration>[0-9]*);?");
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);

        Map<String, Integer> robotSpeed = new LinkedHashMap<>();
        ArrayDeque<String> products = new ArrayDeque<>();

        String robot;
        int duration;
        while (matcher.find()) {
            robot = matcher.group("robot");
            duration = Integer.parseInt(matcher.group("duration"));
            robotSpeed.put(robot, duration);
        }

        input = scanner.nextLine();
        int[] clock = parseTime(input);
//        int[] processingSkills = robotSpeed.values().stream().mapToInt(integer -> integer).toArray();

        while (!"End".equals(input = scanner.nextLine())) {
            products.offer(input);
        }

        Map<String, String> robotItems = new LinkedHashMap<>();
        Map<String, String> exactHour = new LinkedHashMap<>();

        String currentProduct;
        int countRounds = 0;
        while (!products.isEmpty()) {
            for (Map.Entry<String, Integer> entry : robotSpeed.entrySet()) {
                robot = entry.getKey();
                duration = entry.getValue();
                incrementClock(clock);
                countRounds++;

                if (!robotItems.containsValue(robot)) {
                    currentProduct = products.poll();
                    robotItems.put(currentProduct, robot);
                    exactHour.put(currentProduct, formatClock(clock));
                } else {
                    if (countRounds % duration == 0) {
                        currentProduct = products.poll();
                        robotItems.put(currentProduct, robot);
                        exactHour.put(currentProduct, formatClock(clock));
                    }
                }
            }
        }
        robotItems.forEach((key, value) -> {
            System.out.printf("%s - %s [%s]\n", value, key, exactHour.get(key));
        });
    }
    public static void incrementClock(int[] clock) {
        clock[2]++;
        if (clock[2] == 60) {
            clock[2] = 0;
            clock[1]++;
        }
        if (clock[1] == 60) {
            clock[1] = 0;
            clock[0]++;
        }
    }

    public static int[] parseTime(String time) {
        String[] tokens = time.split(":");
        int[] clock = new int[3];
        clock[0] = Integer.parseInt(tokens[0]);
        clock[1] = Integer.parseInt(tokens[1]);
        clock[2] = Integer.parseInt(tokens[2]);
        return clock;
    }

    public static String formatClock(int[] clock) {
        return String.format("%02d:%02d:%02d", clock[0], clock[1], clock[2]);
    }
}
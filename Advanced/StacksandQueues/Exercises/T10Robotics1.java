package T01StacksQueues.Exercise;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T10Robotics1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("(?<robot>[A-Z]+[0-9]*?)-(?<duration>[0-9]+);?");
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);

        Map<String, Integer> robotCapacity = new LinkedHashMap<>();
        Map<String, Integer> robotWorkTime = new LinkedHashMap<>();

        while (matcher.find()) {
            String robot = matcher.group("robot");
            int duration = Integer.parseInt(matcher.group("duration"));
            robotCapacity.put(robot, duration);
            robotWorkTime.put(robot, 0);
        }

        input = scanner.nextLine();
        int[] clock = parseTime(input);

        Queue<String> commands = new ArrayDeque<>();

        while (!(input = scanner.nextLine()).equals("End")) {
            commands.offer(input);
        }

        while (!commands.isEmpty()) {
            incrementClock(clock);

            String task = commands.poll();
            boolean isTaskAssigned = false;

            for (Map.Entry<String, Integer> entry : robotCapacity.entrySet()) {
                String name = entry.getKey();

                if (robotWorkTime.get(name) == 0) {
                    System.out.printf("%s - %s [%s]\n", name, task, formatClock(clock));
                    robotWorkTime.put(name, entry.getValue());
                    isTaskAssigned = true;
                    break;
                }
            }
            if (!isTaskAssigned) {
                commands.offer(task);
            }
            for (String robot : robotWorkTime.keySet()) {
                if (robotWorkTime.get(robot) > 0) {
                    robotWorkTime.put(robot, robotWorkTime.get(robot) - 1);
                }
            }
        }
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
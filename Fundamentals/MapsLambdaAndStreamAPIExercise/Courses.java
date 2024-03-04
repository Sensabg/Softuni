package MapsLambdaAndStreamAPIExercise;

import java.util.*;
import java.util.stream.Collectors;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> coursesInfo = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {

            String[] info = input.split(" : ");
            String course = info[0];
            String student = info[1];

            coursesInfo.putIfAbsent(course, new ArrayList<>());
            coursesInfo.get(course).add(student);

            input = scanner.nextLine();
        }
        coursesInfo.entrySet().forEach(entry ->
                System.out.printf("%s: %s\n-- %s\n", entry.getKey(), entry.getValue().size(),
                        entry.getValue().stream().map(String::valueOf).collect(Collectors.joining("\n-- "))));
    }
}
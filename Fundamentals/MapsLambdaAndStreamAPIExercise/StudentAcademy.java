package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentsGrades = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String student = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            studentsGrades.putIfAbsent(student, new ArrayList<>());
            studentsGrades.get(student).add(grade);
        }
        studentsGrades.entrySet().stream()
                .filter(entry ->
                        entry.getValue().stream().mapToDouble(Double::doubleValue).sum() / entry.getValue().size() >= 4.50)
                .forEach(entry ->
                        System.out.printf("%s -> %.2f\n", entry.getKey(),
                                entry.getValue().stream().mapToDouble(Double::doubleValue).sum() / entry.getValue().size()));

    }
}
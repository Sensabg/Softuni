package MapsLambdaAndStreamAPIExercise;

import java.util.*;
import java.util.stream.Collectors;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> company = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {

            String[] info = input.split(" -> ");
            String name= info[0];
            String id = info[1];

            List<String> currentCompanyEmployees = company.get(name);
            boolean containsId = currentCompanyEmployees != null && currentCompanyEmployees.contains(id);

            if (!containsId) {
                company.putIfAbsent(name, new ArrayList<>());
                company.get(name).add(id);
            }

            input = scanner.nextLine();
        }
        company.entrySet().forEach(entry ->
                System.out.printf("%s\n-- %s\n", entry.getKey(),
                        entry.getValue().stream().map(String::valueOf).collect(Collectors.joining("\n-- "))));
    }
}

package FinalExams;

import java.util.*;

public class Problem3PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> plantRarity = new LinkedHashMap<>();
        LinkedHashMap<String, List<Double>> plantGrades = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        String input;
        String[] info;

        for (int i = 0; i < n; i++) {
            input = scanner.nextLine();
            info = input.split("<->");
            String plant = info[0];
            String rare = info[1];

            plantRarity.put(plant, rare);
            plantGrades.put(plant, new ArrayList<>());
        }

        String regexSplit = "[:\\s-]+";

        while (!"Exhibition".equals(input = scanner.nextLine())) {
            info = input.split(regexSplit);
            String command = info[0];
            String plant = info[1];

            if (plantRarity.containsKey(plant)) {
                switch (command) {

                    case "Rate":
                        double grade = Double.parseDouble(info[2]);
                        plantGrades.get(plant).add(grade);
                        break;

                    case "Update":
                        String rare = info[2];
                        plantRarity.put(plant, rare);
                        break;

                    case "Reset":
                        plantGrades.get(plant).clear();
                        break;
                }
            } else {
                System.out.println("error");
            }
        }
        System.out.println("Plants for the exhibition: ");
        for (Map.Entry<String, String> plantInfo : plantRarity.entrySet()) {
            String plantName = plantInfo.getKey();
            String rare = plantInfo.getValue();
            List<Double> grades = plantGrades.get(plantName);
            double avrGrade;

            if (grades.isEmpty()) {
                avrGrade = 0;
            } else {
               avrGrade = grades.stream().mapToDouble(Double::doubleValue).sum() / grades.size();
            }
            System.out.printf("- %s; Rarity: %s; Rating: %.2f\n", plantName, rare, avrGrade);
        }
    }
}

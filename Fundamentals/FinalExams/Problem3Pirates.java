package FinalExams;

import java.util.*;

public class Problem3Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> cityPopulation = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> cityGold = new LinkedHashMap<>();
        List<String> cities = new ArrayList<>();

        String input;
        String[] info;
        String city;
        int people;
        int gold;
        int currentGold;
        int currentPopulation;

        while (!"Sail".equals(input = scanner.nextLine())) {
            info = input.split("\\|\\|");
            city = info[0];
            people = Integer.parseInt(info[1]);
            gold = Integer.parseInt(info[2]);

            if (cities.contains(city)) {
                currentPopulation = cityPopulation.get(city);
                currentGold = cityGold.get(city);
                cityPopulation.put(city, currentPopulation + people);
                cityGold.put(city, currentGold + gold);
            } else {
                cityPopulation.put(city, people);
                cityGold.put(city, gold);
                cities.add(city);
            }
        }

        while (!"End".equals(input = scanner.nextLine())) {
            info = input.split("=>");
            String task = info[0];
            city = info[1];

            switch (task) {

                case "Plunder":
                    people = Integer.parseInt(info[2]);
                    gold = Integer.parseInt(info[3]);
                    currentPopulation = cityPopulation.get(city);
                    currentGold = cityGold.get(city);

                    cityPopulation.put(city, currentPopulation - people);
                    cityGold.put(city, currentGold - gold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n", city, Math.min(currentGold, gold), people);

                    if (cityPopulation.get(city) == 0 || cityGold.get(city) == 0) {
                        System.out.printf("%s has been wiped off the map!\n", city);
                        cityPopulation.remove(city);
                        cityGold.remove(city);
                        cities.remove(city);
                    }
                    break;

                case "Prosper":
                    gold = Integer.parseInt(info[2]);
                    currentGold = cityGold.get(city);
                    if (gold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        cityGold.put(city, currentGold + gold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n", gold, city, currentGold + gold);
                    }
                    break;
            }
        }
        if (cities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n", cityGold.size());
            for (Map.Entry<String, Integer> cityInfo : cityPopulation.entrySet()) {
                city = cityInfo.getKey();
                people = cityInfo.getValue();
                gold = cityGold.get(city);

                System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n", city, people, gold);
            }
        }
    }
}
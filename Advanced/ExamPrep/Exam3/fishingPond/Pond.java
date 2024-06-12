package fishingPond;

import java.util.ArrayList;
import java.util.List;

public class Pond {
    private int capacity;
    private List<Fish> fishes;

    // Constructor
    public Pond(int capacity) {
        this.capacity = capacity;
        this.fishes = new ArrayList<>();
    }

    // Method to add a fish
    public void addFish(Fish fish) {
        if (fishes.size() < capacity) {
            fishes.add(fish);
        }
    }

    // Method to remove a fish by species
    public boolean removeFish(String species) {
        return fishes.removeIf(fish -> fish.getSpecies().equals(species));
    }

    // Method to get the oldest fish
    public Fish getOldestFish() {
        return fishes.stream().max((fish1, fish2) -> Integer.compare(fish1.getAge(), fish2.getAge())).orElse(null);
    }

    // Method to get a fish by species
    public Fish getFish(String species) {
        return fishes.stream().filter(fish -> fish.getSpecies().equals(species)).findFirst().orElse(null);
    }

    // Method to get the count of fishes
    public int getCount() {
        return fishes.size();
    }

    // Method to get the number of vacancies in the pond
    public int getVacancies() {
        return capacity - fishes.size();
    }

    // Method to report fishes
    public String report() {
        StringBuilder report = new StringBuilder("Fishes in the pond:\n");
        for (Fish fish : fishes) {
            report.append(fish.toString()).append("\n");
        }
        return report.toString().trim();
    }
}
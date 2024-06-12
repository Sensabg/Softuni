package ExamPrep.Exam3.T03fishingPond;

import java.util.ArrayList;
import java.util.List;

public class Pond {
    private int capacity;
    private List<Fish> fishes;

    public Pond(int capacity) {
        this.capacity = capacity;
        this.fishes = new ArrayList<>();
    }

    public void addFish(Fish fish) {
        if (fishes.size() < capacity) {
            fishes.add(fish);
        }
    }

    public boolean removeFish(String species) {
        return fishes.removeIf(fish -> fish.getSpecies().equals(species));
    }

    public Fish getOldestFish() {
        return fishes.stream().max((fish1, fish2) -> Integer.compare(fish1.getAge(), fish2.getAge())).orElse(null);
    }

    public Fish getFish(String species) {
        return fishes.stream().filter(fish -> fish.getSpecies().equals(species)).findFirst().orElse(null);
    }

    public int getCount() {
        return fishes.size();
    }

    public int getVacancies() {
        return capacity - fishes.size();
    }

    public String report() {
        StringBuilder report = new StringBuilder("Fishes in the pond:\n");
        for (Fish fish : fishes) {
            report.append(fish.toString()).append("\n");
        }
        return report.toString().trim();
    }
}

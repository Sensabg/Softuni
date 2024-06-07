package ExamPrep.Exam2.T03sharkHaunt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basin {
    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    public void addShark(Shark shark) {
        if (sharks.size() < capacity) {
            sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }

    public boolean removeShark(String kind) {
        return sharks.removeIf(shark -> shark.getKind().equals(kind));
    }

    public Shark getLargestShark() {
        return sharks.stream().max(Comparator.comparingInt(Shark::getLength)).orElse(null);
    }

    public Shark getShark(String kind) {
        return sharks.stream().filter(shark -> shark.getKind().equals(kind)).findFirst().orElse(null);
    }

    public int getCount() {
        return sharks.size();
    }

    public int getAverageLength() {
        return (int) sharks.stream().mapToInt(Shark::getLength).average().orElse(0);
    }

    public String report() {
        StringBuilder report = new StringBuilder("Sharks in " + name + ":\n");
        for (Shark shark : sharks) {
            report.append(shark.toString()).append("\n");
        }
        return report.toString().trim();
    }
}
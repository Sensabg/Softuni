package spaceCrafts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LaunchPad {
    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spacecrafts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addSpacecraft(spaceCrafts.Spacecraft spacecraft) {

        if (spacecrafts.size() < capacity) {
//            if (spacecrafts.stream().noneMatch(s -> s.getName().equals(spacecraft.getName()))) {
            spacecrafts.add(spacecraft);
        } else {
            System.out.println(("This launchpad is at full capacity!"));
        }
    }

    public boolean removeSpacecraft(String name) {
        if (spacecrafts.removeIf(spacecraft -> spacecraft.getName().equals(name))) {
            return true;
        }
        return false;
    }

    public String getHeaviestSpacecraft() {
        return spacecrafts.stream()
                .max(Comparator.comparingInt(Spacecraft::getWeight))
                .map(spacecraft -> spacecraft.getName() + " - " + spacecraft.getWeight() + "kg.")
                .orElse("No spacecraft found");
    }

    public spaceCrafts.Spacecraft getSpacecraft(String name) {
        return spacecrafts.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return spacecrafts.size();
    }

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {
        List<Spacecraft> result = spacecrafts.stream()
                .filter(spacecraft -> spacecraft.getMissionType().equals(missionType))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("There are no spacecrafts to respond this criteria.");
        }

        return result;
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("Spacecrafts launched from ").append(name).append(":\n");
        if (spacecrafts.isEmpty()) {
            builder.append("none");
        } else {
            for (int i = 0; i < spacecrafts.size(); i++) {
                builder.append(i + 1).append(". ").append(spacecrafts.get(i).getName()).append("\n");
            }
        }
        return builder.toString().trim();
    }
}
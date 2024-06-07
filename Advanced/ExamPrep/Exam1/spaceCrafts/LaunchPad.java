package spaceCrafts;

import java.util.ArrayList;
import java.util.List;

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
            if (spacecrafts.stream().noneMatch(s -> s.getName().equals(spacecraft.getName()))) {
                spacecrafts.add(spacecraft);
            } else {
                throw new RuntimeException("This spacecraft already exists!");
            }
        } else {
            System.out.println(("This launchpad is at full capacity!"));
        }
    }

    public boolean removeSpacecraft(String name) {
        for (Spacecraft spacecraft : spacecrafts) {
            if (spacecraft.getName().equals(name)) {
                spacecrafts.remove(spacecraft);
                return true;
            }
        }
        return false;
    }

    public String getHeaviestSpacecraft() {
        if (spacecrafts.isEmpty()) {
            return null;
        }
        Spacecraft heaviest = spacecrafts.get(0);
        for (Spacecraft spacecraft : spacecrafts) {
            if (spacecraft.getWeight() > heaviest.getWeight()) {
                heaviest = spacecraft;
            }
        }
        return heaviest.getName() + " - " + heaviest.getWeight() + "kg";
    }

    public spaceCrafts.Spacecraft getSpacecraft(String name) {
        return spacecrafts.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return spacecrafts.size();
    }

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {
        List<Spacecraft> result = new ArrayList<>();
        for (Spacecraft spacecraft : spacecrafts) {
            if (spacecraft.getMissionType().equals(missionType)) {
                result.add(spacecraft);
            }
        }
        if (result.isEmpty()) {
            System.out.println("There are no spacecrafts to respond this criteria.");
        }
        return result;
    }


    public String getStatistics() {

        test.spaceCrafts1.LaunchPad launchPad = new test.spaceCrafts1.LaunchPad(getName(), getCapacity());
        StringBuilder build = new StringBuilder();

        build.append("Spacecrafts launched from ").append(launchPad.getName()).append(":");
        if (spacecrafts.isEmpty()) {
            build.append(System.lineSeparator()).append("none");
        } else {
            build.append(System.lineSeparator());
            for (int i = 0; i < spacecrafts.size(); i++) {
                build.append(i + 1).append(". ").append(spacecrafts.get(i).getName()).append(System.lineSeparator());
            }
        }
//        spacecrafts.forEach(spacecraft -> build.append(spacecraft.getName()).append(System.lineSeparator()));
        return build.toString().trim();
    }
}
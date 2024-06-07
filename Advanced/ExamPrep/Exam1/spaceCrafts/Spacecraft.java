package spaceCrafts;

public class Spacecraft {
    private String name;
    private String missionType;
    private String target;
    private String objective;
    private int weight;

    public Spacecraft(String name, String missionType, String target, String objective, int weight) {
        this.name = name;
        this.missionType = missionType;
        this.target = target;
        this.objective = objective;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getMissionType() {
        return missionType;
    }

    public String getTarget() {
        return target;
    }

    public String getObjective() {
        return objective;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "The mission of " + name + " was to reach " + target + " and to " + objective;
    }

}

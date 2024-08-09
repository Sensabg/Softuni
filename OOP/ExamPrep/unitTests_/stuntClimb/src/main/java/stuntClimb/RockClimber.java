package stuntClimb;

public class RockClimber {
    private final String name;
    private final double strength;

    public RockClimber(String name, double strength) {
        this.name = name;
        this.strength = strength;
    }

    public String getName() {
        return this.name;
    }

    public double getStrength() {
        return this.strength;
    }
}

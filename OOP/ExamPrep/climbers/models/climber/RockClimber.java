package climbers.models.climber;

public class RockClimber extends BaseClimber {
    private static final int INITIAL_STRENGTH = 120;
    private static final int DECREASE_UNITS = 60;

    public RockClimber(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void climb() {
        this.setStrength(this.getStrength() - DECREASE_UNITS);
    }
}

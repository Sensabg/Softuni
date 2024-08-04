package climbers.models.climber;

public class WallClimber extends BaseClimber {
    private static final int INITIAL_STRENGTH = 90;
    private static final int DECREASE_UNITS = 30;

    public WallClimber(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void climb() {
        this.setStrength(this.getStrength() - DECREASE_UNITS);
    }
}

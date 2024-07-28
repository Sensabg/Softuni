package climbers.models.climber;

public class WallClimber extends BaseClimber {


    private static final int INITIAL_STRENGTH = 90;

    private static final int EXHAUSTION_UNITS = 30;

    protected WallClimber(String name) {
        super(name, INITIAL_STRENGTH);
    }


    @Override
    public void climb() {
        this.setStrength(this.getStrength() - EXHAUSTION_UNITS);
    }
}

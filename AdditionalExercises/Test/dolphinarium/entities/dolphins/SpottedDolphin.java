package dolphinarium.entities.dolphins;

public class SpottedDolphin extends BaseDolphin {
    private static final int ADDITIONAL_JUMP_ENERGY_COST = 90;

    public SpottedDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    protected void performJump() {
        setEnergy(getEnergy() - ADDITIONAL_JUMP_ENERGY_COST);
    }
}

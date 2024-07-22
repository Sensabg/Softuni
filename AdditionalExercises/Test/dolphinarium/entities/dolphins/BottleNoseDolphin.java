package dolphinarium.entities.dolphins;

public class BottleNoseDolphin extends BaseDolphin {
    private static final int ADDITIONAL_JUMP_ENERGY_COST = 190;

    public BottleNoseDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    protected void performJump() {
        setEnergy(getEnergy() - ADDITIONAL_JUMP_ENERGY_COST);
    }
}

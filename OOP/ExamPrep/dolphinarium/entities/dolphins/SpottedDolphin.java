package dolphinarium.entities.dolphins;

public class SpottedDolphin extends BaseDolphin {
    private static final int ADDITIONAL_JUMP_ENERGY_COST = 100;

    public SpottedDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {
        decreaseEnergy(ADDITIONAL_JUMP_ENERGY_COST);
    }
}
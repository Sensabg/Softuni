package dolphinarium.entities.dolphins;

public class SpinnerDolphin extends BaseDolphin {
    private static final int ADDITIONAL_JUMP_ENERGY_COST = 40;

    public SpinnerDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {
        decreaseEnergy(ADDITIONAL_JUMP_ENERGY_COST);
    }
}
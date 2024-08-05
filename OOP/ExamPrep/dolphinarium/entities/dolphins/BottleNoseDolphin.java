package dolphinarium.entities.dolphins;

public class BottleNoseDolphin extends BaseDolphin {
    private static final int ADDITIONAL_JUMP_ENERGY_COST = 190;

    public BottleNoseDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {
        decreaseEnergy(ADDITIONAL_JUMP_ENERGY_COST);
    }

}
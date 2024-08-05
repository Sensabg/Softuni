package dolphinarium.entities.dolphins;

import dolphinarium.entities.foods.Food;

public abstract class BaseDolphin implements Dolphin {
    private String name;
    private int energy;
    private static final int JUMP_ENERGY_COST = 10;
    protected BaseDolphin(String name, int energy) {
        setName(name);
        setEnergy(energy);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Dolphin name cannot be null or empty.");
        }
        this.name = name;
    }

    public int getEnergy() {

        return energy;
    }

    protected void setEnergy(int energy) {
        this.energy = energy;
    }

    public void jump() {
        decreaseEnergy(JUMP_ENERGY_COST);
    }
    protected void decreaseEnergy(int decrement) {
        setEnergy(Math.max(energy -= decrement, 0));
    }
    public void eat(Food food) {
        setEnergy(energy + food.getCalories());
    }
}
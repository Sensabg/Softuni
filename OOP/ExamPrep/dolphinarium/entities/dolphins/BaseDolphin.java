package dolphinarium.entities.dolphins;

import dolphinarium.entities.foods.Food;

public abstract class BaseDolphin implements Dolphin {
    private String name;
    private int energy;

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

        return Math.max(0, energy);
    }

    protected void setEnergy(int energy) {
        this.energy = Math.max(energy, 0);
    }

    public void jump() {
        setEnergy(this.energy - 10);
    }

    public void eat(Food food) {
        setEnergy(this.energy + food.getCalories());
    }
}

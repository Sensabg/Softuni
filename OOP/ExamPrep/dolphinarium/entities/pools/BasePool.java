package dolphinarium.entities.pools;

import dolphinarium.entities.dolphins.Dolphin;
import dolphinarium.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class BasePool implements Pool {
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Dolphin> dolphins;

    protected BasePool(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.dolphins = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Pool name cannot be null or empty.");
        }
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Collection<Food> getFoods() {
        return Collections.unmodifiableCollection(foods);
    }

    public Collection<Dolphin> getDolphins() {
        return Collections.unmodifiableCollection(dolphins);
    }

    public void addDolphin(Dolphin dolphin) {
        if (dolphins.size() >= capacity) {
            throw new IllegalStateException("Not enough capacity.");
        }
        if (dolphin.getEnergy() <= 0) {
            throw new IllegalArgumentException("Dolphin energy cannot be below or equal to 0.");
        }
        dolphins.add(dolphin);
    }

    public void removeDolphin(Dolphin dolphin) {
        dolphins.remove(dolphin);
    }

    public void addFood(Food food) {
        foods.add(food);
    }
}

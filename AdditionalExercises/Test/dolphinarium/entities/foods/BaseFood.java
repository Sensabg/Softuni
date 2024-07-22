package dolphinarium.entities.foods;

public abstract class BaseFood implements Food {
    private final int calories;

    protected BaseFood(int calories) {
        this.calories = calories;
    }

    @Override
    public int getCalories() {
        return this.calories;
    }
}

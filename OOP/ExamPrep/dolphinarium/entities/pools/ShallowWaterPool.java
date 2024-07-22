package dolphinarium.entities.pools;

public class ShallowWaterPool extends BasePool {
    private static final int SHALLOW_WATER_POOL_CAPACITY = 2;

    public ShallowWaterPool(String name) {
        super(name, SHALLOW_WATER_POOL_CAPACITY);
    }
}

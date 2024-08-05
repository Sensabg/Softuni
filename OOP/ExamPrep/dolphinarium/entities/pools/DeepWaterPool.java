package dolphinarium.entities.pools;

public class DeepWaterPool extends BasePool {
    private static final int DEEP_WATER_POOL_CAPACITY = 5;

    public DeepWaterPool(String name) {
        super(name, DEEP_WATER_POOL_CAPACITY);
    }
}
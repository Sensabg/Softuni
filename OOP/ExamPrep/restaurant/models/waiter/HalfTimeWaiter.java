package restaurant.models.waiter;

public class HalfTimeWaiter extends BaseWaiter {
    private static final int INITIAL_EFFICIENCY = 4;

    public HalfTimeWaiter(String name) {
        super(name, INITIAL_EFFICIENCY);
    }

    @Override
    public void work() {
        if (getEfficiency() > 0) {
            setEfficiency(Math.max(0, getEfficiency() - 2));
        }
    }
}

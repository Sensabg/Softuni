package restaurant.models.waiter;

public class FullTimeWaiter extends BaseWaiter {
    private static final int INITIAL_EFFICIENCY = 8;

    public FullTimeWaiter(String name) {
        super(name, INITIAL_EFFICIENCY);
    }

    @Override
    public void work() {
        if (getEfficiency() > 0) {
            setEfficiency(Math.max(0, getEfficiency() - 1));
        }
    }
}

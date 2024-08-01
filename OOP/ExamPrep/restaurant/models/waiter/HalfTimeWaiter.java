package restaurant.models.waiter;

public class HalfTimeWaiter extends BaseWaiter {
    private static final int INITIAL_EFFICIENCY = 4;

    public HalfTimeWaiter(String name) {
        super(name, INITIAL_EFFICIENCY);
    }

    @Override
    public void work() {
        int newEfficiency = getEfficiency() - 2;
        if (newEfficiency < 0){
            newEfficiency = 0;
        }
        setEfficiency(newEfficiency);
    }
}

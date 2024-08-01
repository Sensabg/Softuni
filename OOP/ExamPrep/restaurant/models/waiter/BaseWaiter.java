package restaurant.models.waiter;

import restaurant.models.orders.TakenOrders;

import static restaurant.common.ExceptionMessages.WAITER_EFFICIENCY_LESS_THAN_ZERO;
import static restaurant.common.ExceptionMessages.WAITER_NAME_NULL_OR_EMPTY;

public abstract class BaseWaiter implements Waiter {
    private String name;
    private int efficiency;
    private final TakenOrders takenOrders;

    protected BaseWaiter(String name, int efficiency) {
        setName(name);
        setEfficiency(efficiency);
        this.takenOrders = takenOrders();
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(WAITER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        if (efficiency < 0) {
            throw new IllegalArgumentException(WAITER_EFFICIENCY_LESS_THAN_ZERO);
        }
        this.efficiency = efficiency;
    }

    @Override
    public TakenOrders takenOrders() {
        return takenOrders;
    }


    @Override
    public boolean canWork() {
        return efficiency > 0;
    }

    @Override
    public abstract void work();
}

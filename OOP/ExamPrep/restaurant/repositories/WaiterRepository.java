package restaurant.repositories;

import restaurant.models.waiter.Waiter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WaiterRepository implements Repository<Waiter> {
    private Set<Waiter> waiters;

    public WaiterRepository() {
        this.waiters = new HashSet<>();
    }

    @Override
    public void add(Waiter waiter) {
        waiters.add(waiter);
    }

    @Override
    public boolean remove(Waiter waiter) {
        return waiters.remove(waiter);
    }

    @Override
    public Waiter byName(String name) {
        for (Waiter waiter : waiters) {
            if (waiter.getName().equals(name)) {
                return waiter;
            }
        }
        return null;
    }

    @Override
    public Collection<Waiter> getCollection() {
        return Collections.unmodifiableSet(waiters);
    }
}

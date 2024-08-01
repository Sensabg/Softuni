package restaurant.models.working;

import restaurant.models.client.Client;
import restaurant.models.orders.TakenOrders;
import restaurant.models.waiter.Waiter;

import java.util.Collection;

public class WorkingImpl implements Working {
    public void takingOrders(Client client, Collection<Waiter> waiters) {

        Collection<String> orders = client.getClientOrders();

        for (Waiter waiter : waiters) {

            while (waiter.canWork() && orders.iterator().hasNext()) {

                waiter.work();
                String order = orders.iterator().next();
                waiter.takenOrders().getOrdersList().add(order);
                orders.remove(order);
            }
        }
    }
}

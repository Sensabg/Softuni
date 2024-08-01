package restaurant.models.working;

import restaurant.models.client.Client;
import restaurant.models.orders.TakenOrders;
import restaurant.models.waiter.Waiter;

import java.util.Collection;

public class WorkingImpl implements Working{
    public void takingOrders(Client client, Collection<Waiter> waiters) {
        for (Waiter waiter : waiters) {
            if (!waiter.canWork()) continue;

            TakenOrders takenOrders = waiter.takenOrders();
            Collection<String> clientOrders = client.getClientOrders();

            for (String order : clientOrders) {
                if (!waiter.canWork()) break;

                takenOrders.getOrdersList().add(order);
                waiter.work();
            }

            clientOrders.clear();
        }
    }
}

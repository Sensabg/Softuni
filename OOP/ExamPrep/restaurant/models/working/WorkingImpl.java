package restaurant.models.working;

import restaurant.models.client.ClientImpl;
import restaurant.models.waiter.BaseWaiter;
import restaurant.models.orders.TakenOrdersImpl;
import restaurant.models.waiter.Waiter;

import java.util.Collection;
import java.util.Iterator;

public class WorkingImpl {
    public void takingOrders(ClientImpl client, Collection<BaseWaiter> waiters) {
        Iterator<String> clientOrdersIterator = client.getClientOrders().iterator();

        for (BaseWaiter waiter : waiters) {
            while (waiter.canWork() && clientOrdersIterator.hasNext()) {
                String order = clientOrdersIterator.next();
                waiter.work();
                ((TakenOrdersImpl) waiter.takenOrders()).addOrder(order);
                clientOrdersIterator.remove();

                if (!waiter.canWork()) {
                    break;
                }
            }

            if (!clientOrdersIterator.hasNext()) {
                break;
            }
        }
    }
}

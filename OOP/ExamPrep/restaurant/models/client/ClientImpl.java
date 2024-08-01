package restaurant.models.client;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.WAITER_NAME_NULL_OR_EMPTY;

public class ClientImpl implements Client {
    private String name;
    private Collection<String> clientOrders;

    public ClientImpl(String name) {
        setName(name);
        this.clientOrders = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(WAITER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<String> getClientOrders() {
        return clientOrders;
    }

}

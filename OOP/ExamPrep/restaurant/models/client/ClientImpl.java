package restaurant.models.client;

import java.util.ArrayList;
import java.util.Collection;

public class ClientImpl {
    private String name;
    private Collection<String> clientOrders;

    public ClientImpl(String name) {
        setName(name);
        this.clientOrders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Invalid name!");
        }
        this.name = name;
    }

    public Collection<String> getClientOrders() {
        return clientOrders;
    }

    public void addOrder(String order) {
        this.clientOrders.add(order);
    }

    public void removeOrder(String order) {
        this.clientOrders.remove(order);
    }
}

package restaurant.repositories;

import restaurant.models.client.Client;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ClientRepository implements Repository<Client> {
    private Set<Client> clients;

    public ClientRepository() {
        this.clients = new HashSet<>();
    }

    @Override
    public void add(Client client) {
        clients.add(client);
    }

    @Override
    public boolean remove(Client client) {
        return clients.remove(client);
    }

    @Override
    public Client byName(String name) {
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public Collection<Client> getCollection() {
        return Collections.unmodifiableSet(clients);
    }
}

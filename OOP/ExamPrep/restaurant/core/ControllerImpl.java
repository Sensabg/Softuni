package restaurant.core;

import restaurant.common.ConstantMessages;
import restaurant.models.client.Client;
import restaurant.models.client.ClientImpl;
import restaurant.models.waiter.FullTimeWaiter;
import restaurant.models.waiter.HalfTimeWaiter;
import restaurant.models.waiter.Waiter;
import restaurant.repositories.ClientRepository;
import restaurant.repositories.Repository;
import restaurant.repositories.WaiterRepository;

import java.util.List;

import static restaurant.common.ConstantMessages.*;
import static restaurant.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private final Repository<Client> clientRepository;
    private final Repository<Waiter> waiterRepository;
    private String type;
    private String waiterName;

    public ControllerImpl() {
        this.clientRepository = new ClientRepository();
        this.waiterRepository = new WaiterRepository();
    }

    @Override
    public String addWaiter(String type, String waiterName) {

        Waiter waiter;
        switch (type) {
            case "HalfTimeWaiter" -> waiter = new HalfTimeWaiter(waiterName);
            case "FullTimeWaiter" -> waiter = new FullTimeWaiter(waiterName);
            default -> throw new IllegalArgumentException(WAITER_INVALID_TYPE);
        }

        this.waiterRepository.add(waiter);

        return String.format(ConstantMessages.WAITER_ADDED, type, waiterName);
    }

    @Override
    public String addClient(String clientName, String... orders) {
        Client client = new ClientImpl(clientName);

        for (String order : orders) {
            client.getClientOrders().add(order);
        }

        this.clientRepository.add(client);

        return String.format(CLIENT_ADDED, clientName);
    }

    @Override
    public String removeWaiter(String waiterName) {
        Waiter waiter = waiterRepository.byName(waiterName);
        if (waiter == null) {
            throw new IllegalArgumentException(WAITER_DOES_NOT_EXIST);
        }

        waiterRepository.remove(waiter);
        return String.format(WAITER_REMOVE, waiterName);
    }

    @Override
    public String removeClient(String clientName) {

      Client client = clientRepository.byName(clientName);
        if (client == null) {
            throw new IllegalArgumentException(CLIENT_DOES_NOT_EXIST);
        }

        clientRepository.remove(client);
        return String.format(CLIENT_REMOVE, clientName);
    }

    @Override
    public String startWorking(String clientName) {

        List<Waiter> waiters = waiterRepository.getCollection().stream().toList();

        if(waiters.isEmpty()){
            throw new IllegalArgumentException(THERE_ARE_NO_WAITERS);
        }

        return String.format(ORDERS_SERVING,clientName);
    }

    @Override
    public String getStatistics() {

        return null;
    }
}

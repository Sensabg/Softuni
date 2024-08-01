package restaurant.core;

import restaurant.common.ConstantMessages;
import restaurant.models.client.Client;
import restaurant.models.client.ClientImpl;
import restaurant.models.waiter.FullTimeWaiter;
import restaurant.models.waiter.HalfTimeWaiter;
import restaurant.models.waiter.Waiter;
import restaurant.models.working.Working;
import restaurant.models.working.WorkingImpl;
import restaurant.repositories.ClientRepository;
import restaurant.repositories.Repository;
import restaurant.repositories.WaiterRepository;

import java.util.List;

import static restaurant.common.ConstantMessages.*;
import static restaurant.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private final Repository<Client> clientRepository;
    private final Repository<Waiter> waiterRepository;
    private int totalCountOfServedClients = 0;
    private final Working working;
    public ControllerImpl() {
        this.clientRepository = new ClientRepository();
        this.waiterRepository = new WaiterRepository();
        this.working = new WorkingImpl();
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
        client.getClientOrders().addAll(List.of(orders));
        clientRepository.add(client);
        return CLIENT_ADDED.formatted(clientName);
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

        List<Waiter> waiters = waiterRepository.getCollection().stream().filter(Waiter::canWork).toList();
        if (waiters.isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_WAITERS);
        }

        Client client = clientRepository.byName(clientName);
        working.takingOrders(client, waiters);
        totalCountOfServedClients++;

        return ORDERS_SERVING.formatted(clientName);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        String firstRow = FINAL_CLIENTS_COUNT.formatted(totalCountOfServedClients);
        sb.append(firstRow).append(System.lineSeparator());
        sb.append(FINAL_WAITERS_STATISTICS).append(System.lineSeparator());

        for (Waiter waiter : waiterRepository.getCollection()) {
            sb.append(FINAL_WAITER_NAME.formatted(waiter.getName())).append(System.lineSeparator());
            sb.append(FINAL_WAITER_EFFICIENCY.formatted(waiter.getEfficiency())).append(System.lineSeparator());
            String orders = "None";
            if (!waiter.takenOrders().getOrdersList().isEmpty()) {
                orders = String.join(FINAL_WAITER_ORDERS_DELIMITER, waiter.takenOrders().getOrdersList());
            }
            sb.append(FINAL_WAITER_ORDERS.formatted(orders)).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}

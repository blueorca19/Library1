package repositories;

import domain.CommonCart;
import domain.CommonCustomer;
import domain.CommonSubscribe;
import domain.interfaces.Cart;
import domain.interfaces.Customer;
import domain.interfaces.Subscribe;
import repositories.interfaces.CustomerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonCustomerRepository implements CustomerRepository {

    private Map<Integer, Customer> customers = new HashMap<>();


    private List<Subscribe> subscribes = List.of(
            new CommonSubscribe("Moth", 150, 1),
            new CommonSubscribe("HalbYear", 550, 6),
            new CommonSubscribe("Year", 1050, 12));

    private int clientNumber;


    public CommonCustomerRepository() {
        addCustomer("klient1", 1);
        addCustomer("klient2", 2);
        addCustomer("klient3", 0);
        addCustomer("klient4", 1);
    }


    @Override
    public void addCustomer(String customerName, int subscribeId) {
        Cart cart = new CommonCart(++clientNumber);
        Customer customer = new CommonCustomer(customerName, clientNumber, subscribes.get(subscribeId), cart);
        customers.put(clientNumber, customer);
    }

    @Override
    public void removeCustomer(int clientNumber) {

        customers.remove(clientNumber);
    }

    @Override
    public Customer getClientById(int clientNumber) {

        return customers.get(clientNumber);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Subscribe getSubscribeById(int subscribeId) {

        return subscribes.get(subscribeId);
    }

    @Override
    public int getSizeSubscribe() {
        return subscribes.size();
    }

    @Override
    public int getSizeCustomer() {
        return subscribes.size();
    }
}

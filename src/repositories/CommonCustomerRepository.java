package repositories;

import domain.CommonBook;
import domain.CommonCart;
import domain.CommonCustomer;
import domain.CommonSubscribe;
import domain.interfaces.Book;
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


    public CommonCustomerRepository(){
        addCustomer("klient1", 1);
        addCustomer("klient2", 2);
        addCustomer("klient3", 0);
        addCustomer("klient4", 1);
    }

    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    public int getClientNumber() {
        return clientNumber;
    }


    @Override
    public void addCustomer(String customerName, int clientNumber, int subscribeId) {
        Cart cart = new CommonCart(++clientNumber);
        Customer customer = new CommonCustomer(customerName, clientNumber, subscribes.get(subscribeId), cart);
        customers.put(clientNumber, customer);

    }
}

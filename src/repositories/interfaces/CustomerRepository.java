package repositories.interfaces;

import domain.interfaces.Customer;
import domain.interfaces.Subscribe;

import java.util.List;

public interface CustomerRepository {
    void addCustomer(String customerName, int subscribeId);

    void removeCustomer(int clientNumber);

    Customer getClientById(int clientNumber);

    List<Customer> getAllCustomers();

    Subscribe getSubscribeById(int subscribeId);

    int getSizeSubscribe();
    int getSizeCustomer();

    List<Subscribe> getAllSubscribes();





}

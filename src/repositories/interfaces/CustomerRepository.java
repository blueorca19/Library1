package repositories.interfaces;

import domain.interfaces.Customer;

import java.util.List;

public interface CustomerRepository {
    void addCustomer(String customerName, int clientNumber, int subscribeId);

    void removeCustomer(int clientNumber);

    Customer getClientById(int clientNumber);

    List<Customer> getAllCustomers();



}

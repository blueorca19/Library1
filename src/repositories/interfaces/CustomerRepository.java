package repositories.interfaces;

import domain.interfaces.Subscribe;

import java.util.List;

public interface CustomerRepository {
    void addCustomer(String customerName, int clientNumber, int subscribeId);


}

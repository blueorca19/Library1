package services;

import domain.interfaces.Subscribe;
import repositories.interfaces.CustomerRepository;
import services.intefaces.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

public class CommonCustomerService implements CustomerService {

    private CustomerRepository repository;

    public CommonCustomerService(CustomerRepository repository) {
        this.repository = repository;
    }


    public void addCustomer(String customerName, int clientNumber, int subscribeId) {
        if (customerName == null || customerName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (clientNumber <= 0) {
            throw new IllegalArgumentException("Number's client cannot be empty");
        }

        if (subscribeId <= 0) {
            throw new IllegalArgumentException("Subscribe's ID cannot be empty");
        }
        repository.addCustomer(customerName, clientNumber, subscribeId);
    }


}

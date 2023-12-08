package services;

import domain.interfaces.Book;
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

    @Override
    public void addBookToCustomerCart(int customerId, int bookId) {

    }

    @Override
    public List<Book> getCustomerCart(int customerId) {
        return null;
    }

    @Override
    public boolean isCustomerCartEmpty(int customerId) {
        return false;
    }

    @Override
    public void clearCustomerCart(int customerId) {

    }

    @Override
    public boolean isCustomerSubscribed(int customerId) {
        return false;
    }

    @Override
    public void subscribeCustomer(int customerId, int subscribeId) {

    }

    @Override
    public void unsubscribeCustomer(int customerId) {

    }

    @Override
    public double getRemainingSubscriptionTerm(int customerId) {
        return 0;
    }

    @Override
    public int getSubscribedCustomerId(String subscribeName) {
        return 0;
    }


}

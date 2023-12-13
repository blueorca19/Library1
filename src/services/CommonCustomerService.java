package services;

import domain.interfaces.Book;
import domain.interfaces.Customer;
import domain.interfaces.Subscribe;
import repositories.interfaces.BookRepository;
import repositories.interfaces.CustomerRepository;
import services.intefaces.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

public class CommonCustomerService implements CustomerService {

    private CustomerRepository customerRepository;

    private BookRepository bookRepository;

    public CommonCustomerService(CustomerRepository customerRepository, BookRepository bookRepository) {
        this.customerRepository = customerRepository;
        this.bookRepository = bookRepository;
    }

    public void addCustomer(String customerName, int subscribeId) {
        if (customerName == null || customerName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (subscribeId < 0) {
            throw new IllegalArgumentException("Subscribe's ID incorrect");
        }
        customerRepository.addCustomer(customerName, subscribeId);
    }

    @Override
    public void removeCustomer(int clientNumber) {
        if (clientNumber < 0) {
            throw new IllegalArgumentException("Client's ID incorrect");
        }
        customerRepository.getClientById(clientNumber).setActive(false);

    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public List<Customer> getAllActiveCustomers() {
        return customerRepository.getAllCustomers()
                .stream()
                .filter(x -> x.isActive() == true)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> getAllInactiveCustomers() {
        return customerRepository.getAllCustomers()
                .stream()
                .filter(x -> x.isActive() == false)
                .collect(Collectors.toList());
    }

    @Override
    public void addBookToCustomerCart(int clientNumber, int bookId) {
        if (clientNumber < 0) {
            throw new IllegalArgumentException("Client's ID incorrect");
        }

        if (bookId < 0) {
            throw new IllegalArgumentException("Book's ID incorrect");
        }
        customerRepository.getClientById(clientNumber).getCart()
                .addBook(bookRepository.getBookById(bookId));

    }

    @Override
    public List<Book> getCustomerCart(int clientNumber) {
        if (clientNumber < 0) {
            throw new IllegalArgumentException("Client's ID incorrect");
        }
        return customerRepository.getClientById(clientNumber).getCart().getBooks();

    }

    @Override
    public boolean isCustomerCartEmpty(int clientNumber) {
        if (clientNumber < 0 ) {
            throw new IllegalArgumentException("Client's ID incorrect");
        }
        return customerRepository.getClientById(clientNumber).getCart().getBooks().isEmpty();

    }

    @Override
    public void clearCustomerCart(int clientNumber) {
        if (clientNumber < 0) {
            throw new IllegalArgumentException("Client's ID incorrect");
        }
        customerRepository.getClientById(clientNumber).getCart().clear();

    }

    @Override
    public boolean isCustomerSubscribed(int clientNumber) {
        if (clientNumber < 0 ) {
            throw new IllegalArgumentException("Client's ID incorrect");
        }
        return customerRepository.getClientById(clientNumber).getSubscribe().isActive();
    }

    @Override
    public void subscribeCustomer(int clientNumber, int subscribeId) {
        if (clientNumber < 0 ) {
            throw new IllegalArgumentException("Client's ID incorrect");

        }
        if (subscribeId < 0 ) {
            throw new IllegalArgumentException("Subscribe's ID incorrect");
        }

        customerRepository.getClientById(clientNumber).setSubscribe(customerRepository.getSubscribeById(subscribeId));

    }

    @Override
    public void unsubscribeCustomer(int clientNumber) {
        if (clientNumber < 0 ) {
            throw new IllegalArgumentException("Client's ID incorrect");

        }
        customerRepository.getClientById(clientNumber).getSubscribe().setActive(false);

    }

    @Override
    public double getRemainingSubscriptionTerm(int clientNumber) {
        if (clientNumber < 0 ) {
            throw new IllegalArgumentException("Client's ID incorrect");

        }

        return customerRepository.getClientById(clientNumber).getSubscribe().getTerm();
    }

    @Override
    public List<Customer> getListSubscribedCustomer(int subscribeId) {
        if (subscribeId < 0 ) {
            throw new IllegalArgumentException("Subscribe's ID incorrect");
        }

        return customerRepository.getAllCustomers().stream()
                .filter(x -> x.getSubscribe().equals(customerRepository.getSubscribeById(subscribeId)))
                .collect(Collectors.toList());

    }


}

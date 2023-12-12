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
            throw new IllegalArgumentException("Subscribe's ID cannot be empty");
        }
        customerRepository.addCustomer(customerName, subscribeId);
    }

    @Override
    public void addBookToCustomerCart(int clientNumber, int bookId) {
        if (clientNumber < 0) {
            throw new IllegalArgumentException("Client's number cannot be null");
        }

        if (bookId < 0) {
            throw new IllegalArgumentException("Book's ID cannot be null");
        }
        customerRepository.getClientById(clientNumber).getCart()
                .addBook(bookRepository.getBookById(bookId));

    }

    @Override
    public List<Book> getCustomerCart(int customerId) {
        return customerRepository.getClientById(customerId).getCart().getBooks();

    }

    @Override
    public boolean isCustomerCartEmpty(int customerId) {
        return customerRepository.getClientById(customerId).getCart().getBooks().isEmpty();

    }

    @Override
    public void clearCustomerCart(int customerId) {
        customerRepository.getClientById(customerId).getCart().clear();

    }

    @Override
    public boolean isCustomerSubscribed(int customerId) {
        return customerRepository.getClientById(customerId).getSubscribe().isActive();
    }

    @Override
    public void subscribeCustomer(int customerId, int subscribeId) {
        customerRepository.getClientById(customerId).setSubscribe(customerRepository.getSubscribeById(subscribeId));

    }

    @Override
    public void unsubscribeCustomer(int customerId) {
        customerRepository.getClientById(customerId).getSubscribe().setActive(false);

    }

    @Override
    public double getRemainingSubscriptionTerm(int customerId) {

        return customerRepository.getClientById(customerId).getSubscribe().getTerm();
    }

    @Override
    public List<Customer> getListSubscribedCustomer(int subscribeId) {
        return customerRepository.getAllCustomers().stream()
                .filter(x->x.getSubscribe().equals(customerRepository.getSubscribeById(subscribeId)))
                .collect(Collectors.toList());

    }

}

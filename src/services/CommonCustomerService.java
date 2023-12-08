package services;

import domain.interfaces.Book;
import domain.interfaces.Subscribe;
import repositories.interfaces.BookRepository;
import repositories.interfaces.CustomerRepository;
import services.intefaces.CustomerService;

import java.util.List;

public class CommonCustomerService implements CustomerService {

    private CustomerRepository customerRepository;

    private BookRepository bookRepository;

    public CommonCustomerService(CustomerRepository customerRepository, BookRepository bookRepository) {
        this.customerRepository = customerRepository;
        this.bookRepository = bookRepository;
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
        customerRepository.addCustomer(customerName, clientNumber, subscribeId);
    }

    @Override
    public void addBookToCustomerCart(int clientNumber, int bookId) {
        customerRepository.getClientById(clientNumber).getCart().addBook(bookRepository.getBookById(bookId));

     /* Customer currentCustomer = customerRepository.getClientById(clientNumber);
      Book currentBook = bookRepository.getBookById(bookId);
      currentCustomer.getCart().addBook(currentBook);*/

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
    public void subscribeCustomer(int customerId, Subscribe subscribe) {
        customerRepository.getClientById(customerId).setSubscribe(subscribe);

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

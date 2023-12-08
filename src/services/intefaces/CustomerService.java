package services.intefaces;

import domain.interfaces.Book;
import domain.interfaces.Cart;
import domain.interfaces.Subscribe;

import java.util.List;

public interface CustomerService {
    void addCustomer(String customerName, int clientNumber, int subscribeId);

    void addBookToCustomerCart(int clientNumber, int bookId); // для добавления книги в корзину покупателя.

    List<Book> getCustomerCart(int customerId); // для получения списка книг в корзине покупателя.

    boolean isCustomerCartEmpty(int customerId); // для проверки, пуста ли корзина у покупателя.

    void clearCustomerCart(int customerId); // для очистки корзины покупателя.


    boolean isCustomerSubscribed(int customerId); // - для проверки, подписан ли покупатель на какой-либо тариф

    void subscribeCustomer(int customerId, Subscribe subscribe);// - для подписки покупателя на определенный тариф.

    void unsubscribeCustomer(int customerId); //- для отмены подписки у покупателя.

    double getRemainingSubscriptionTerm(int customerId);// - для получения оставшегося срока действия подписки у покупателя.

    int getSubscribedCustomerId(String subscribeName); //- для получения id покупателя, подписанного на определенный тариф.
}

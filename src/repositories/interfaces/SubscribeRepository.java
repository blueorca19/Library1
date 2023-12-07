package repositories.interfaces;

import domain.interfaces.Book;
import domain.interfaces.Subscribe;

import java.util.List;

public interface SubscribeRepository {
    List<Subscribe> getAllSubscribes();
    void addSubscribe (String name, double price, int term);


}

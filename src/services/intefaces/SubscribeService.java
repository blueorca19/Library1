package services.intefaces;

import domain.interfaces.Book;
import domain.interfaces.Subscribe;

import java.util.List;

public interface SubscribeService {
    void addSubscribe (String name, double price, int term);

    List<Subscribe> getAllActiveSubscribe();
}


package services.intefaces;

import domain.interfaces.Cart;
import domain.interfaces.Subscribe;

import java.util.List;

public interface CustomerService {
    void addCustomer (String customerName, int clientNumber, int subscribeId);

}


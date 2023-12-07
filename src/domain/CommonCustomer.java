package domain;

import domain.interfaces.Cart;
import domain.interfaces.Customer;
import domain.interfaces.Subscribe;

import java.util.Objects;

public class CommonCustomer implements Customer {

    private String name;
    private int clientNumber;
    private Subscribe subscribe;
    private boolean isActive;
    private Cart cart;


    public CommonCustomer(String name, int clientNumber, Subscribe subscribe, Cart cart) {
        this.name = name;
        this.clientNumber = clientNumber;
        this.subscribe = subscribe;
        this.subscribe.setActive(true);
        this.cart = cart;
        this.isActive = true;
    }

    public String getName() {
        return name;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonCustomer that = (CommonCustomer) o;
        return clientNumber == that.clientNumber && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, clientNumber);
    }

    @Override
    public String toString() {
        return "Читатель: {" +
                "Имя - " + name + '\'' +
                ", Номер читательского билета - " + clientNumber +
                '}';
    }
}

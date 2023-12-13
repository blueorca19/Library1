package domain.interfaces;

public interface Customer {

    String getName();

    int getClientNumber();

    Cart getCart();

    Subscribe getSubscribe();

    void setSubscribe(Subscribe subscribe);
    void setActive(boolean active);

    boolean isActive();

}

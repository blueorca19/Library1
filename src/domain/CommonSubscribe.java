package domain;

import domain.interfaces.Subscribe;

public class CommonSubscribe implements Subscribe {

    private String name;

    private boolean isActive;

    private double price;

    private int term;

    public CommonSubscribe(String name, double price, int term) {
        this.name = name;
        this.price = price;
        this.term = term;
        this.isActive = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getTerm() {
        return term;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

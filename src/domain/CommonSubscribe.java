package domain;

import domain.interfaces.Subscribe;

public class CommonSubscribe implements Subscribe {


    private int subscribeId;
    private String name;

    private boolean isActive;

    private int term;

    public CommonSubscribe(int subscribeId, String name, int term) {
        this.subscribeId = subscribeId;
        this.name = name;
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
    public void setActive(boolean active) {
        this.isActive = active;
    }

    @Override
    public String toString() {
        return String.format("Подписка: ID - %d, Наименование - %s" + "\n", subscribeId, name);
    }
}

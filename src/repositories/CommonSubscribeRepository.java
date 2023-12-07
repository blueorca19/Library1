package repositories;

import domain.CommonSubscribe;
import domain.interfaces.Subscribe;
import repositories.interfaces.SubscribeRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonSubscribeRepository implements SubscribeRepository {

    private Map<Integer, Subscribe> subscribes = new HashMap<>();

    public CommonSubscribeRepository() {
        addSubscribe("Month", 100, 1);
        addSubscribe("halfYear", 600, 6);
        addSubscribe("Year", 1200, 12);
    }

    @Override
    public List<Subscribe> getAllSubscribes() {
        return new ArrayList<>(subscribes.values());
    }

    @Override
    public void addSubscribe(String name, double price, int term) {
        Subscribe subscribe = new CommonSubscribe(name, price, term);
    }
}

package services;

import domain.interfaces.Subscribe;
import repositories.interfaces.SubscribeRepository;
import services.intefaces.SubscribeService;

import java.util.List;
import java.util.stream.Collectors;

public class CommonSubscribesService implements SubscribeService {

    private SubscribeRepository repository;

    public CommonSubscribesService(SubscribeRepository repository) {
        this.repository = repository;
    }


    @Override
    public void addSubscribe(String name, double price, int term) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price cannot be equals or less 0");
        }
        if (term <= 0) {
            throw new IllegalArgumentException("Term cannot be equals or less 0");
        }
        repository.addSubscribe(name, price, term);
    }

    @Override
    public List<Subscribe> getAllActiveSubscribe() {
        return repository.getAllSubscribes()
                .stream()
                .filter(x -> x.isActive())
                .collect(Collectors.toList());
    }


}

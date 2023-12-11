package controllers;

import java.util.ArrayList;
import java.util.List;

public class ControllerMain {

    private ControllerBook controllerBook;
    private ControllerCustomer controllerCustomer;

    public ControllerMain(ControllerBook controllerBook, ControllerCustomer controllerCustomer) {
        this.controllerBook = controllerBook;
        this.controllerCustomer = controllerCustomer;
    }

    public List<Object> sendRequest(String query) {
        try {
            String[] parts = query.split(" ");
            int objectNum = Integer.parseInt(parts[0]);
            int operationNum = Integer.parseInt(parts[1]);
            List<Object> result = new ArrayList<>();
            switch (objectNum) {
                case 1:
                    switch (operationNum) {
                        case 1:
                            controllerBook.addBook();
                            break;
                        case 2:
                            result.addAll(controllerBook.getAllBooks());
                            break;
                        case 3:
                            result.addAll(controllerBook.getAllActiveBooks());
                            break;
                        case 4:
                            result.addAll(controllerBook.getAllBooksByTitle());
                            break;
                        case 5:
                            result.addAll(controllerBook.getAllBooksByAuthor());
                            break;
                        case 6:
                            result.addAll(controllerBook.getAllBooksByYear());
                            break;
                        case 7:
                            result.add(controllerBook.getBookCount());
                            break;
                        case 8:
                            controllerBook.removeBook();
                            break;
                    }
                case 2:
                    switch (objectNum) {
                        case 1:
                            controllerCustomer.addCustomer();
                            break;
                        case 2:
                            controllerCustomer.addBookToCustomerCart();
                            break;
                        case 3:
                            result.addAll(controllerCustomer.getCustomerCart());
                            break;
                        case 4:
                            controllerCustomer.isCustomerCartEmpty();
                            break;
                        case 5:
                            controllerCustomer.clearCustomerCart();
                            break;
                        case 6:
                            controllerCustomer.isCustomerSubscribed();
                            break;
                        case 7:
                            controllerCustomer.subscribeCustomer();
                            break;
                        case 8:
                            controllerCustomer.unsubscribeCustomer();
                            break;
                        case 9:
                            result.add(controllerCustomer.getRemainingSubscriptionTerm());
                            break;
                        case 10:
                            result.addAll(controllerCustomer.getListSubscribedCustomer());
                            break;
                    }

            } return result;
        } catch (Exception e) {
            System.out.println("Произошла ошибка в главном контроллере ");
            throw new RuntimeException(e);
        }
    }
}


package application;

import controllers.ControllerBook;
import controllers.ControllerCustomer;
import controllers.ControllerMain;
import repositories.CommonBookRepository;
import repositories.CommonCustomerRepository;
import repositories.interfaces.BookRepository;
import repositories.interfaces.CustomerRepository;
import services.CommonBookService;
import services.CommonCustomerService;
import services.intefaces.BookService;
import services.intefaces.CustomerService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        BookRepository bookRepository = new CommonBookRepository();
        CustomerRepository customerRepository = new CommonCustomerRepository();
        BookService bookService = new CommonBookService(bookRepository);
        CustomerService customerService = new CommonCustomerService(customerRepository, bookRepository);
        ControllerBook controllerBook = new ControllerBook(bookService);
        ControllerCustomer controllerCustomer = new ControllerCustomer(customerService);
        ControllerMain controllerMain = new ControllerMain(controllerBook, controllerCustomer);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберете объект: \n" +
                    "1. Книги. \n" +
                    "2. Клиент. \n" +
                    "0. Завершение работы.");
            try {
                int objectNum = Integer.parseInt(scanner.nextLine());
                switch (objectNum) {
                    case 1:
                        System.out.println(" Выберете операцию: \n" +
                                "1. Добавить книгу. \n" +
                                "2. Получить список всех книг. \n" +
                                "3. Получить список активных книг. \n" +
                                "4. Получить список книг по названию. \n" +
                                "5. Получить список книг по автору. \n" +
                                "6. Получить список книг по году. \n" +
                                "7. Получить количество книг.\n" +
                                "8. Удалить книгу по id. ");
                        int operationNum = Integer.parseInt(scanner.nextLine());
                        controllerMain.sendRequest(objectNum + " " + operationNum).forEach(System.out::println);
                        break;
                    case 2:
                        System.out.println(" Выберете операцию: \n" +
                                "1. Добавить клиента. \n" +
                                "2. Добавить книгу в корзину клиента. \n" +
                                "3. Получить список книг, которые лежат в корзине. \n" +
                                "4. Проверить корзину клиента на пустоту. \n" +
                                "5. Очистить корзину клиента. \n" +
                                "6. Получить сведения о подписках клиента.\n" +
                                "7. Проверить подписку на определенный тариф. \n" +
                                "8. Отменить подписку у клиента. \n" +
                                "9. Получить срок действия оставшейся подписки. \n" +
                                "10.Получить список клиентов по определенному тарифу подписки.  ");
                        int operationNum1 = Integer.parseInt(scanner.nextLine());
                        controllerMain.sendRequest(objectNum + " " + operationNum1).forEach(System.out::println);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Некорректный ввод");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка! ");

            }
        }

    }

}


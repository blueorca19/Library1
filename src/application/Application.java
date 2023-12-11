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
            System.out.println("Выберете объект: \n " +
                    "1. Книги. \n" +
                    "2. Клиент. \n" +
                    "0. Завершение работы.");
            try {
                int objectNum = Integer.parseInt(scanner.nextLine());
                switch (objectNum) {
                    case 1:
                        System.out.println(" Выберете операцию: \n" +
                                "1. Добавить книгу. \n " +
                                "2. Получить список активных книг. \n " +
                                "3. Получить список книг по названию. \n" +
                                "4. Получить список книг по автору. \n" +
                                "5. Получить список книг по году. \n" +
                                "6. Получить количество книг.\n"+
                                "7. Удалить книгу по id. ");

                }
            }

        }

    }
}

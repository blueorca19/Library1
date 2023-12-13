package controllers;

import domain.interfaces.Book;
import services.intefaces.BookService;

import java.util.List;
import java.util.Scanner;

public class ControllerBook {
    private BookService service;

    public ControllerBook(BookService service) {
        this.service = service;
    }


    public void addBook() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название книги: ");

            String title = scanner.nextLine();
            System.out.println("Введите имя автора: ");
            String author = scanner.nextLine();
            System.out.println("Введите год издания: ");
            int year = Integer.parseInt(scanner.nextLine());
            service.addBook(title,author,year);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getAllBooks() {
        try {
            System.out.println("Вывод всех книг:");
            return service.getAllBooks();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<Book> getAllActiveBooks() {
        try {
            System.out.println(" Вывод всех книг в наличии: ");
            return service.getAllActiveBooks();
        } catch (Exception e) {
            System.out.println("Произошла ошибка вывода");
            throw new RuntimeException(e);
        }
    }

    public List<Book> getAllBooksByTitle() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название книги для поиска: ");
            String title = scanner.nextLine();
            return service.getAllBooksByTitle(title);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getAllBooksByAuthor() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите автора книги для поиска: ");
            String author = scanner.nextLine();
            return service.getAllBooksByAuthor(author);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getAllBooksByYear() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите год книги для поиска: ");
            int year = Integer.parseInt(scanner.nextLine());
            return service.getAllBooksByYear(year);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getBookCount() {
        try {
            System.out.println(" Вывод общего количества книг: ");
            return service.getBookCount();
        } catch (Exception e) {
            System.out.println("Произошла ошибка вывода");
            throw new RuntimeException(e);
        }
    }

    public void removeBook() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите ID книги, которую хотите удалить: ");
            int id = Integer.parseInt(scanner.nextLine());
            service.removeBook(id);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

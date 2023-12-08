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

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeBook() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите ID книги, которую хотите удалить: ");
            int id = Integer.parseInt(scanner.nextLine());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getAllActiveBooks() {
        return service.getAllActiveBooks();
    }

    public List<Book> getAllBooksByTitle(String title) {
        return service.getAllBooksByTitle(title);

    }

    public List<Book> getAllBooksByAuthor(String author) {
        return service.getAllBooksByAuthor(author);

    }

    public List<Book> getAllBooksByYear(int year) {
        return service.getAllBooksByYear(year);

    }

    public int getBookCount() {
        return service.getBookCount();

    }
}

package services.intefaces;

import domain.interfaces.Book;

import java.util.List;

public interface BookService {

    void addBook (String title, String author, int year);

    List<Book> getAllBooks();

    List<Book> getAllActiveBooks();

    List<Book> getAllBooksByTitle(String title);

    List<Book> getAllBooksByAuthor(String author);

    List<Book> getAllBooksByYear(int year);

    int getBookCount();
    void removeBook(int bookId);

}

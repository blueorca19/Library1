package services.intefaces;

import domain.interfaces.Book;

import java.util.List;

public interface BookService {

    void addBook(String title, String author, int year);

    List<Book> getAllActiveBooks();

    List<Book> getAllBooksByTitle(String title); // для получения списка всех книг по названию.

    List<Book> getAllBooksByAuthor(String author); // для получения списка всех книг по автору.

    List<Book> getAllBooksByYear(int year); // для получения списка всех книг по году.

    int getBookCount(); // для получения общего количества книг в хранилище.
}

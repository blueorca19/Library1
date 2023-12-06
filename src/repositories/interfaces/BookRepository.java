package repositories.interfaces;

import domain.interfaces.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAllBooks();
    void addBook (int id, String title, String author, int year);

}

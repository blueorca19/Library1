package repositories.interfaces;

import domain.interfaces.Book;

import java.util.List;

public interface BookRepository {

    void addBook(String title, String author, int year);
    void removeBook(int bookId);
    Book getBookById(int bookId);
    List<Book> getAllBooks();


}

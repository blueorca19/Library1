package services.intefaces;

import domain.interfaces.Book;

import java.util.List;

public interface BookService {

    void addBook (String title, String author, int year);

    List<Book> getAllActiveBooks();
}

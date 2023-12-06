package domain.interfaces;

import java.util.List;

public interface Cart {
    int getId();

    List<Book> getBooks();

    boolean addBook(Book book);

    boolean deleteBook(int id);

    boolean deleteBook(String title);

    double getPrice();


    void clear();




}

package repositories;

import domain.CommonBook;
import domain.interfaces.Book;
import repositories.interfaces.BookRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonBookRepository implements BookRepository {

    private Map<Integer, Book> books = new HashMap<>();

    private int currentId;

    public CommonBookRepository() {
        addBook("title1", "author1", 1991);
        addBook("title2", "author2", 1992);
        addBook("title3", "author3", 1993);
        addBook("title4", "author4", 1994);
        addBook("title5", "author5", 1995);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }
    @Override
    public void addBook(String title, String author, int year) {
        Book book = new CommonBook(title, author, year);
        book.setId(++currentId);
        books.put(currentId, book);
    }

    @Override
    public void removeBook(int bookId) {
        books.remove(bookId);
    }

    @Override
    public Book getBookById(int bookId) {
        return books.get(bookId);
    }

}

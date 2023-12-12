package services;

import domain.interfaces.Book;
import repositories.interfaces.BookRepository;
import services.intefaces.BookService;

import java.util.List;
import java.util.stream.Collectors;

public class CommonBookService implements BookService {

    private BookRepository repository;

    public CommonBookService(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addBook(String title, String author, int year) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Year cannot be equals or less 0");
        }
        repository.addBook(title, author, year);
    }

    @Override
    public List<Book> getAllBooks() {

        return repository.getAllBooks();
    }

    @Override
    public List<Book> getAllActiveBooks() {
         return repository.getAllBooks()
                .stream()
                .filter(x -> x.isActive())
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksByTitle(String title) {
        return repository.getAllBooks()
                .stream()
                .filter(x -> x.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        return repository.getAllBooks()
                .stream()
                .filter(x -> x.getAuthor().contains(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksByYear(int year) {
        return repository.getAllBooks()
                .stream()
                .filter(x -> x.getYear() == year)
                .collect(Collectors.toList());
    }

    @Override
    public int getBookCount() {
        return (int) repository.getAllBooks()
                .stream()
                .count();
    }

    @Override
    public void removeBook(int bookId) {

        repository.removeBook(bookId);
    }
}

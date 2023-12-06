package domain;

import domain.interfaces.Book;
import domain.interfaces.Cart;
import domain.interfaces.Subscribe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommonCart implements Cart {

    private int id;
    private List<Book> books= new ArrayList<>();

    private Subscribe subscribe;

    public Subscribe getSubscribe() {
        return subscribe;
    }

    public CommonCart(int id, List<Book> books, Subscribe subscribe) {
        this.id = id;
        this.books = books;
        this.subscribe= subscribe;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public boolean addBook(Book book) {
        return false;
    }

    @Override
    public boolean deleteBook(int id) {
        return false;
    }

    @Override
    public boolean deleteBook(String title) {
        return false;
    }

    @Override
    public Subscribe getPrice() {
        return getSubscribe();
    }


    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CommonCart that = (CommonCart) object;
        return id == that.id && Objects.equals(books, that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, books);
    }

    @Override
    public String toString() {

        return books.toString();
    }
}

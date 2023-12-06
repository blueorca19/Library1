package domain;

import domain.interfaces.Book;
import domain.interfaces.Cart;
import domain.interfaces.Subscribe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CommonCart implements Cart {

    private int id;
    private List<Book> books = new ArrayList<>();

    private Subscribe subscribe;

    public CommonCart(int id, List<Book> books, Subscribe subscribe) {
        this.id = id;
        this.books = books;
        this.subscribe = subscribe;

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
        return books.add(book);
    }

    @Override
    public boolean deleteBook(int id) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteBook(String title) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getTitle().equals(title)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    //todo Дописать методы
    @Override
    public double getPrice() {
        return subscribe.getPrice();
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

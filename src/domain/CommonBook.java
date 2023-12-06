package domain;

import domain.interfaces.Book;

import java.util.Objects;

public class CommonBook implements Book {

    private int id;
    private String title;
    private String author;
    private int year;
    private boolean isActive;

    public CommonBook(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isActive = true;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonBook that = (CommonBook) o;
        return id == that.id && year == that.year && isActive == that.isActive && Objects.equals(title, that.title) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, year, isActive);
    }

    @Override
    public String toString() {
        return "Книга:{" +
                "Номер =" + id +
                ", Наименование ='" + title + '\'' +
                ", Автор ='" + author + '\'' +
                ", Год =" + year +
                ", Наличие =" + isActive +
                '}';
    }
}

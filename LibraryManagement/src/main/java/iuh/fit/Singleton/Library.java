package iuh.fit.Singleton;




import iuh.fit.FactoryMethod.Book;
import iuh.fit.Observer.Observer;

import java.util.*;

public class Library {
    private static Library instance;
    private List<Book> books = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private Library() {}

    public static Library getInstance() {
        if (instance == null) instance = new Library();
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        notifyObservers("Có sách mới: " + book.getTitle());
    }

    public List<Book> getBooks() {
        return books;
    }

    // Observer
    public void attach(Observer o) {
        observers.add(o);
    }

    public void notifyObservers(String msg) {
        for (Observer o : observers) {
            o.update(msg);
        }
    }
}

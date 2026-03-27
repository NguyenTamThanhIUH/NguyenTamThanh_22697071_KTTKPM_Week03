package iuh.fit.Strategy;

import iuh.fit.FactoryMethod.Book;

import java.util.List;

public interface SearchStrategy {
    List<Book> search(List<Book> books, String keyword);
}
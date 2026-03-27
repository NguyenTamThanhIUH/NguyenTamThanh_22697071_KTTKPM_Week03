package iuh.fit.Strategy;

import iuh.fit.FactoryMethod.Book;

import java.util.ArrayList;
import java.util.List;

public class SearchByTitle implements SearchStrategy {
    public List<Book> search(List<Book> books, String k) {
        List<Book> rs = new ArrayList<>();
        for (Book b : books)
            if (b.getTitle().contains(k)) rs.add(b);
        return rs;
    }
}

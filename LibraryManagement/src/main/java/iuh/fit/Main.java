package iuh.fit;

import iuh.fit.Decorator.BasicBorrow;
import iuh.fit.Decorator.Borrow;
import iuh.fit.Decorator.ExtendTime;
import iuh.fit.Decorator.SpecialEdition;
import iuh.fit.FactoryMethod.Book;
import iuh.fit.FactoryMethod.BookFactory;
import iuh.fit.Observer.Observer;
import iuh.fit.Observer.User;
import iuh.fit.Singleton.Library;
import iuh.fit.Strategy.SearchByTitle;
import iuh.fit.Strategy.SearchStrategy;


public class Main {
    public static void main(String[] args) {

        Library lib = Library.getInstance();

        // Observer
        Observer u1 = new User("Thanh");
        lib.attach(u1);

        // Factory
        Book b1 = BookFactory.createBook("paper","Java","James","IT");
        Book b2 = BookFactory.createBook("ebook","Python","Guido","IT");

        lib.addBook(b1);
        lib.addBook(b2);

        // Strategy
        SearchStrategy s = new SearchByTitle();
        System.out.println("Search:");
        for(Book b : s.search(lib.getBooks(), "Java")) {
            System.out.println(b.getTitle());
        }

        // Decorator
        Borrow borrow = new SpecialEdition(new ExtendTime(new BasicBorrow()));
        borrow.borrow();
    }
}
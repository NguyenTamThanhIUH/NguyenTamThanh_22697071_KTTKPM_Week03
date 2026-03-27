package iuh.fit.FactoryMethod;

public abstract class Book {
    protected String title, author, category;

    public Book(String t, String a, String c) {
        title = t;
        author = a;
        category = c;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }
}


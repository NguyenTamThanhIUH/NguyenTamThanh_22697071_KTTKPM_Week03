package iuh.fit.FactoryMethod;

public class BookFactory {
    public static Book createBook(String type, String t, String a, String c) {
        switch(type) {
            case "paper": return new PaperBook(t,a,c);
            case "ebook": return new EBook(t,a,c);
            case "audio": return new AudioBook(t,a,c);
            default: throw new IllegalArgumentException("Invalid type");
        }
    }
}

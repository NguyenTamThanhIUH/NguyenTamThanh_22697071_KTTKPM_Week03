package iuh.fit;

public class Stock extends Subject {
    private String name;
    private double price;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers("Stock " + name + " có giá mới: " + price);
    }
}

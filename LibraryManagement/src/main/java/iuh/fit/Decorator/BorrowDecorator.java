package iuh.fit.Decorator;

public abstract class BorrowDecorator implements Borrow {
    protected Borrow borrow;

    public BorrowDecorator(Borrow b) {
        this.borrow = b;
    }
}
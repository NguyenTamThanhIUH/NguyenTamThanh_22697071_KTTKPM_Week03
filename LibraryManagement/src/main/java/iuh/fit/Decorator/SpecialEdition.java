package iuh.fit.Decorator;

public class SpecialEdition extends BorrowDecorator {
    public SpecialEdition(Borrow b) { super(b); }

    public void borrow() {
        borrow.borrow();
        System.out.println("-> Phiên bản đặc biệt");
    }
}
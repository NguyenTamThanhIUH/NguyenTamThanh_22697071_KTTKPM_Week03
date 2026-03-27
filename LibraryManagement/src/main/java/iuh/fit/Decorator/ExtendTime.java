package iuh.fit.Decorator;

public class ExtendTime extends BorrowDecorator {
    public ExtendTime(Borrow b) { super(b); }

    public void borrow() {
        borrow.borrow();
        System.out.println("-> Gia hạn thời gian");
    }
}
package iuh.fit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // ===== STOCK =====
        Stock stock = new Stock("AAPL", 150);

        Observer inv1 = new Investor("An");
        Observer inv2 = new Investor("Bình");

        stock.attach(inv1);
        stock.attach(inv2);

        stock.setPrice(155);
        stock.setPrice(160);

        System.out.println("------------------");

        // ===== TASK =====
        Task task = new Task("Build API");

        Observer dev1 = new TeamMember("Nam");
        Observer dev2 = new TeamMember("Lan");

        task.attach(dev1);
        task.attach(dev2);

        task.setStatus("In Progress");
        task.setStatus("Done");
    }
}
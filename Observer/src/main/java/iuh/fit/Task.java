package iuh.fit;

public class Task extends Subject {
    private String name;
    private String status;

    public Task(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers("Task " + name + " -> " + status);
    }
}
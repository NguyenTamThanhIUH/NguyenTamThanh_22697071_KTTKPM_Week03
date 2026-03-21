package iuh.fit;

import java.util.ArrayList;
import java.util.List;


public class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children; // Can contain Files or Directories

    public Directory(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

   
    public void addComponent(FileSystemComponent component) {
        if (component != null) {
            children.add(component);
        }
    }

   
    public void removeComponent(FileSystemComponent component) {
        if (component != null) {
            children.remove(component);
        }
    }

    public List<FileSystemComponent> getChildren() {
        return new ArrayList<>(children);
    }

   
    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystemComponent component : children) {
            totalSize += component.getSize();
        }
        return totalSize;
    }

    @Override
    public void display() {
        display(0);
    }

    
    public void display(int indent) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            indentation.append("  ");
        }
        System.out.println(indentation + "📁 Directory: " + name + " (" + formatSize(getSize()) + ")");

        for (FileSystemComponent component : children) {
            if (component instanceof File) {
                ((File) component).display(indent + 1);
            } else if (component instanceof Directory) {
                ((Directory) component).display(indent + 1);
            }
        }
    }

    private String formatSize(long bytes) {
        if (bytes <= 0) return "0 B";
        final String[] units = new String[]{"B", "KB", "MB", "GB"};
        int digitGroups = (int) (Math.log10(bytes) / Math.log10(1024));
        return String.format("%.2f %s", bytes / Math.pow(1024, digitGroups), units[digitGroups]);
    }
}

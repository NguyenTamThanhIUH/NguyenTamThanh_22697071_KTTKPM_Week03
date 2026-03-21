package iuh.fit;

/**
 * File Class - Leaf Node in Composite Pattern
 * Represents a physical file that can only contain data
 */
public class File implements FileSystemComponent {
    private String name;
    private long size; // in bytes

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public void display() {
        display(0);
    }

    /**
     * Display with indentation for better visualization
     */
    public void display(int indent) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            indentation.append("  ");
        }
        System.out.println(indentation + "📄 File: " + name + " (" + formatSize(size) + ")");
    }

    private String formatSize(long bytes) {
        if (bytes <= 0) return "0 B";
        final String[] units = new String[]{"B", "KB", "MB", "GB"};
        int digitGroups = (int) (Math.log10(bytes) / Math.log10(1024));
        return String.format("%.2f %s", bytes / Math.pow(1024, digitGroups), units[digitGroups]);
    }
}

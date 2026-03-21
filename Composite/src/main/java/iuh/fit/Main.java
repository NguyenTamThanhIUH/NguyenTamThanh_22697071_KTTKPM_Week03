package iuh.fit;


public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  COMPOSITE DESIGN PATTERN - FILE SYSTEM");
        System.out.println("========================================\n");

        // Create root directory
        Directory root = new Directory("Root");

        // Create some files in root directory
        File file1 = new File("file1.txt", 5120); // 5 KB
        File file2 = new File("file2.pdf", 2048000); // ~2 MB
        root.addComponent(file1);
        root.addComponent(file2);

        // Create subdirectory "Documents"
        Directory documents = new Directory("Documents");
        File doc1 = new File("resume.docx", 1024000); // ~1 MB
        File doc2 = new File("report.xlsx", 512000); // ~500 KB
        File doc3 = new File("notes.txt", 10240); // ~10 KB
        documents.addComponent(doc1);
        documents.addComponent(doc2);
        documents.addComponent(doc3);
        root.addComponent(documents);

        // Create subdirectory "Images" inside Documents
        Directory images = new Directory("Images");
        File image1 = new File("photo1.jpg", 5242880); // ~5 MB
        File image2 = new File("photo2.png", 3145728); // ~3 MB
        images.addComponent(image1);
        images.addComponent(image2);
        documents.addComponent(images);

        // Create subdirectory "Videos" in root
        Directory videos = new Directory("Videos");
        File video1 = new File("movie1.mp4", 524288000); // ~500 MB
        File video2 = new File("tutorial.mkv", 262144000); // ~250 MB
        videos.addComponent(video1);
        videos.addComponent(video2);
        root.addComponent(videos);

        // Create subdirectory "Downloads"
        Directory downloads = new Directory("Downloads");
        File download1 = new File("software.iso", 4294967296L); // ~4 GB
        downloads.addComponent(download1);
        root.addComponent(downloads);

        // Display the entire file system tree
        System.out.println("FILE SYSTEM STRUCTURE:\n");
        root.display();

        // Display size information
        System.out.println("\n========================================");
        System.out.println("SIZE INFORMATION:");
        System.out.println("========================================");
        System.out.println("Total size of root: " + formatSize(root.getSize()));
        System.out.println("Total size of Documents: " + formatSize(documents.getSize()));
        System.out.println("Total size of Images: " + formatSize(images.getSize()));
        System.out.println("Total size of Videos: " + formatSize(videos.getSize()));
        System.out.println("Total size of Downloads: " + formatSize(downloads.getSize()));

        // Demonstrate adding and removing components
        System.out.println("\n========================================");
        System.out.println("DEMONSTRATING ADD/REMOVE OPERATIONS:");
        System.out.println("========================================");

        File tempFile = new File("temp.tmp", 204800); // 200 KB
        System.out.println("\nAdding temp.tmp (200 KB) to Documents...");
        documents.addComponent(tempFile);
        System.out.println("New size of Documents: " + formatSize(documents.getSize()));

        System.out.println("\nRemoving temp.tmp from Documents...");
        documents.removeComponent(tempFile);
        System.out.println("New size of Documents: " + formatSize(documents.getSize()));

        // Demonstrate nested directory structure
        System.out.println("\n========================================");
        System.out.println("COMPLETE FILE SYSTEM AFTER MODIFICATIONS:");
        System.out.println("========================================\n");
        root.display();
    }

    private static String formatSize(long bytes) {
        if (bytes <= 0) return "0 B";
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(bytes) / Math.log10(1024));
        return String.format("%.2f %s", bytes / Math.pow(1024, digitGroups), units[digitGroups]);
    }
}
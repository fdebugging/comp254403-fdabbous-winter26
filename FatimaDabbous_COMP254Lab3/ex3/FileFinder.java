import java.io.File;

public class FileFinder {

    public static void find(File path, String filename) {

        if (path.isDirectory()) {

            File[] files = path.listFiles();

            if (files != null) {
                for (File file : files) {
                    find(file, filename);
                }
            }

        } else {
            if (path.getName().equals(filename)) {
                System.out.println("Found: " + path.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        File startPath = new File("/Users/fatimadabbous/Desktop");
        String targetFile = "test.txt";

        System.out.println("Searching for file: " + targetFile);

        find(startPath, targetFile);
    }
}

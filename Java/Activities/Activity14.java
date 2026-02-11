import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class Activity14 {
    public static void main(String[] args) {
        try {
            // Create a new text file using the default File Class
            File file = new File("src/main/resources/newfile.txt");
            
            // Use createNewFile() method to create a file
            boolean fileCreated = file.createNewFile();
            if (fileCreated) {
                System.out.println("File created successfully: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            
            // Write some text into the text file
            String content = "This is a sample text file.\nIt demonstrates FileUtils operations.\nJava File I/O is powerful!";
            FileUtils.writeStringToFile(file, content, "UTF8");
            System.out.println("\nData written to file successfully.");
            
            // Read the file using readFileToString()
            System.out.println("\n--- Reading Original File ---");
            String fileData = FileUtils.readFileToString(file, "UTF8");
            System.out.println("Data in file: " + fileData);
            
            // Create a new directory named "destDir"
            File destDir = new File("destDir");
            if (!destDir.exists()) {
                destDir.mkdir();
                System.out.println("\n--- Directory Created ---");
                System.out.println("Directory created: " + destDir.getName());
            }
            
            // Copy the text file into this directory using copyFileToDirectory()
            FileUtils.copyFileToDirectory(file, destDir);
            System.out.println("\nFile copied to directory successfully.");
            
            // Get file from new directory using getFile() method
            File newFile = FileUtils.getFile(destDir, "sample.txt");
            
            // Read data from the new file using readFileToString()
            System.out.println("\n--- Reading Copied File ---");
            String newFileData = FileUtils.readFileToString(newFile, "UTF8");
            System.out.println("Data in copied file: " + newFileData);
            
            // Display file information
            System.out.println("\n--- File Information ---");
            System.out.println("Original file path: " + file.getAbsolutePath());
            System.out.println("Copied file path: " + newFile.getAbsolutePath());
            System.out.println("File size: " + newFile.length() + " bytes");
            
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

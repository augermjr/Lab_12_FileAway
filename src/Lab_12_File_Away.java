import javax.swing.JFileChooser;
import java.util.Scanner;
import java.nio.file.Path;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Lab_12_File_Away {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");

        chooser.setCurrentDirectory(target.toFile());

        try {
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFIle().toPath();
                inFile = new Scanner(target);
                while(inFile.hasNextLine()){
                    line = inFile.nextLine();
                    System.out.println(line);
                 }
                inFile.close();
            }
            else {
                System.out.println("No file selected. Please try again and select a file");
                System.exit(0);
            }
        } catch (FileNotFoundException e){
            System.out.println("Error: File not found.");
            e.printStackTrace();
        }
        System.out.println("Hello world!");
    }
}
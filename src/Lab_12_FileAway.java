    import javax.swing.*;
    import java.io.*;
    import java.nio.file.*;
    import static java.nio.file.StandardOpenOption.CREATE;
    public class Lab_12_FileAway {
        public static void main(String[] args)
        {
            JFileChooser chooser = new JFileChooser();
            File selectedFile;
            String rec = "";
            try {
                File workingDirectory = new File(System.getProperty("user.dir"));
                chooser.setCurrentDirectory(workingDirectory);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    selectedFile = chooser.getSelectedFile();
                    Path file = selectedFile.toPath();
                    InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                    int line = 0;
                    int chars = 0;
                    int numWords = 0;
                    while (reader.ready()) {
                        rec = reader.readLine();
                        line++;
                        System.out.printf("\n%4d %-60s ", line, rec);
                        chars = chars + rec.trim().length();
                        String[] words = rec.trim().split(" ");
                        numWords += words.length;
                    }
                    line++;
                    reader.close();
                    System.out.println("\n\nOpened file: " + selectedFile.getName());
                    System.out.printf("File contains: \n%-10d Lines\n%-10d Words\n%-10d Characters", line, numWords, chars);
                }
                else {
                    System.out.println("No file selected. Please try again and select a file");
                    System.exit(0);
                }
            }
            catch (FileNotFoundException e)
            {
                System.out.println("Error: File not found.");
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

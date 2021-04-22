package ToDo;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileHandler {

    private final Path folderPath;
    private final Path tempFolderPath = Path.of("todostemp.txt");

    public FileHandler(Path folderPath) {
        this.folderPath = folderPath;
    }

    public void saveTheFile(List<String> input) throws IOException {
        StringBuilder tasks = new StringBuilder();
        if (!Files.exists(folderPath)) {
            Files.createFile(folderPath);
        }
        try {
            for (String s : input) {
                tasks.append(s).append("\n");
            }
            Files.write(folderPath, Collections.singleton(tasks));
        } catch (IOException e) {
            System.err.println("Uh-oh something went wrong :(");
        }
    }

    public List<String> readTheFile() {
        try {
            return Files.readAllLines(folderPath);
        } catch (IOException e) {
            System.err.println("Uh-oh something went wrong :(");
        }
        return null;
    }

    public void updateTheFile(String s) {
        try (FileWriter fw = new FileWriter(String.valueOf(folderPath), true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(s);
        } catch (IOException e) {
            System.err.println("Saving todo failed :(");
            e.printStackTrace();
        }
    }

    public void removeTheLine(int i) throws IOException {

        File inputFile = new File(String.valueOf(folderPath));
        File tempFile = new File(String.valueOf(tempFolderPath));
        if (!Files.exists(folderPath)) {
            Files.createFile(folderPath);
        }
        if (!Files.exists(tempFolderPath)) {
            Files.createFile(tempFolderPath);
        }

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;
        int count = 0;

        while ((currentLine = reader.readLine()) != null) {
            count++;
            if (count == i) {
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }

        writer.close();
        reader.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);
    }

    public void updateATask(int taskNum, String newLine) throws IOException {
        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(folderPath, StandardCharsets.UTF_8));
            fileContent.set(taskNum, newLine);
            Files.write(folderPath, fileContent, StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            System.err.println("FIle not found");
        }
    }
}

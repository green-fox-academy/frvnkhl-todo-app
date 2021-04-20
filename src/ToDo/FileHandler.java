package ToDo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileHandler {

    private final Path folderPath;

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
        Files.write(Paths.get(folderPath), contentTo)
    }


}

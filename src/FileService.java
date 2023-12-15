import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    private File file;

    public FileService(String fileName) throws IOException {
        file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void write(String val) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(val);
            writer.newLine();
        }
    }

    public List<String> read() throws IOException {

        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String s;
            while((s = reader.readLine()) != null) {
                list.add(s);
            }
        }

        return list;
    }

}

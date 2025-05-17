import java.io.*;
import java.util.List;

public class JobStorage {
    private final String path = "job_data.bin";

    public void exportToDisk(List<Job> jobs) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(jobs);
        } catch (IOException ex) {
            System.out.println("Ошибка записи: " + ex.getMessage());
        }
    }

    public List<Job> importFromDisk() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            return (List<Job>) in.readObject();
        } catch (Exception e) {
            return new LinkedList<>();
        }
    }
}

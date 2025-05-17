import java.util.LinkedList;
import java.util.List;

public class JobRegistry {
    private final List<Job> entries = new LinkedList<>();

    public void insert(Job job) {
        entries.add(job);
    }

    public void erase(int idx) {
        if (idx >= 0 && idx < entries.size()) {
            entries.remove(idx);
        }
    }

    public Job fetch(int idx) {
        return entries.get(idx);
    }

    public List<Job> listAll() {
        return new LinkedList<>(entries);
    }

    public int total() {
        return entries.size();
    }
}

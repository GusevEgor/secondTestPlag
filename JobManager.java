public class JobManager {
    private final JobRegistry registry;

    public JobManager(JobRegistry registry) {
        this.registry = registry;
    }

    public void add(String name, String note, LocalDate deadline) {
        registry.insert(new Job(name, note, deadline));
    }

    public void setDone(int idx) {
        Job j = registry.fetch(idx);
        if (j != null) {
            j.markDone();
        }
    }

    public void remove(int idx) {
        registry.erase(idx);
    }

    public void show() {
        int id = 0;
        for (Job j : registry.listAll()) {
            System.out.println(id++ + " -> " + j);
        }
    }

    public JobRegistry getRegistry() {
        return registry;
    }
}

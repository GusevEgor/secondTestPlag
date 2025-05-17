public class JobApp {
    public static void main(String[] args) {
        JobRegistry registry = new JobRegistry();
        JobManager manager = new JobManager(registry);
        JobStorage storage = new JobStorage();
        JobInterface ui = new JobInterface(manager, storage);
        ui.launch();
    }
}

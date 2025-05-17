import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class JobInterface {
    private final JobManager manager;
    private final JobStorage storage;
    private final Scanner input = new Scanner(System.in);

    public JobInterface(JobManager manager, JobStorage storage) {
        this.manager = manager;
        this.storage = storage;
    }

    public void launch() {
        List<Job> loaded = storage.importFromDisk();
        for (Job j : loaded) {
            manager.getRegistry().insert(j);
        }

        String cmd;
        while (true) {
            printMenu();
            cmd = input.nextLine();

            switch (cmd) {
                case "1" -> register();
                case "2" -> check();
                case "3" -> delete();
                case "4" -> manager.show();
                case "5" -> storage.exportToDisk(manager.getRegistry().listAll());
                case "0" -> {
                    storage.exportToDisk(manager.getRegistry().listAll());
                    return;
                }
                default -> System.out.println("Неверная команда.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n== Job Tracker ==");
        System.out.println("1. Новое задание");
        System.out.println("2. Отметить выполненным");
        System.out.println("3. Удалить");
        System.out.println("4. Показать все");
        System.out.println("5. Сохранить");
        System.out.println("0. Выход");
        System.out.print("Выберите: ");
    }

    private void register() {
        System.out.print("Название: ");
        String name = input.nextLine();
        System.out.print("Комментарий: ");
        String note = input.nextLine();
        System.out.print("Крайний срок (ГГГГ-ММ-ДД): ");
        LocalDate deadline = LocalDate.parse(input.nextLine());
        manager.add(name, note, deadline);
    }

    private void check() {
        System.out.print("ID задания: ");
        int id = Integer.parseInt(input.nextLine());
        manager.setDone(id);
    }

    private void delete() {
        System.out.print("ID задания: ");
        int id = Integer.parseInt(input.nextLine());
        manager.remove(id);
    }
}

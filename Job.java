import java.io.Serializable;
import java.time.LocalDate;

public class Job implements Serializable {
    private String name;
    private String note;
    private boolean done;
    private LocalDate deadline;

    public Job(String name, String note, LocalDate deadline) {
        this.name = name;
        this.note = note;
        this.deadline = deadline;
        this.done = false;
    }

    public String getName() { return name; }
    public String getNote() { return note; }
    public LocalDate getDeadline() { return deadline; }
    public boolean isDone() { return done; }
    public void markDone() { this.done = true; }

    @Override
    public String toString() {
        return String.format("(%s) %s - %s : %s",
                done ? "✓" : " ", name, deadline.toString(), note);
    }
}

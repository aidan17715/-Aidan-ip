import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline task with a due date.
 */
public class Deadline extends Task {

    protected LocalDate by;

    /**
     * Creates a new deadline task with the given description and due date.
     *
     * @param description The description of the deadline task.
     * @param by The due date in yyyy-mm-dd format.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = LocalDate.parse(by);
    }

    /**
     * Returns the due date of the deadline.
     *
     * @return The due date as a LocalDate.
     */
    public LocalDate getBy() {
        return by;
    }

    /**
     * Returns a string representation of the deadline task.
     *
     * @return A formatted string with [D] prefix and deadline date.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}

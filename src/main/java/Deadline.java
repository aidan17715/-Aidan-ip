import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
     * @throws JohnException If the date format is invalid.
     */
    public Deadline(String description, String by) throws JohnException {
        super(description);
        try {
            this.by = LocalDate.parse(by);
        } catch (DateTimeParseException e) {
            throw new JohnException("OOPS!!! Invalid date format. Please use yyyy-mm-dd format.");
        }
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

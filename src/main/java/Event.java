import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents an event task with a start and end date.
 */
public class Event extends Task {

    protected LocalDate from;
    protected LocalDate to;

    /**
     * Creates a new event task with the given description and time period.
     *
     * @param description The description of the event.
     * @param from The start date in yyyy-mm-dd format.
     * @param to The end date in yyyy-mm-dd format.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = LocalDate.parse(from);
        this.to = LocalDate.parse(to);
    }

    /**
     * Returns the start date of the event.
     *
     * @return The start date as a LocalDate.
     */
    public LocalDate getFrom() {
        return from;
    }

    /**
     * Returns the end date of the event.
     *
     * @return The end date as a LocalDate.
     */
    public LocalDate getTo() {
        return to;
    }

    /**
     * Returns a string representation of the event task.
     *
     * @return A formatted string with [E] prefix and event time period.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");
        return "[E]" + super.toString() + " (from: " + from.format(formatter) + " to: " + to.format(formatter) + ")";
    }
}

/**
 * Represents a todo task without any date/time attached.
 */
public class Todo extends Task {

    /**
     * Creates a new todo task with the given description.
     *
     * @param description The description of the todo task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns a string representation of the todo task.
     *
     * @return A formatted string with [T] prefix and task details.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}

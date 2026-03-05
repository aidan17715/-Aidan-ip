/**
 * Represents an exception specific to the John application.
 * Used to handle errors that occur during task management operations.
 */
public class JohnException extends Exception {
    /**
     * Creates a new JohnException with the specified error message.
     *
     * @param message The error message.
     */
    public JohnException(String message) {
        super(message);
    }
}

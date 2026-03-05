/**
 * Represents an abstract command that can be executed.
 * All commands must implement the execute method.
 */
public abstract class Command {
    /**
     * Executes the command.
     *
     * @param tasks The task list to operate on.
     * @param ui The UI to display messages.
     * @param storage The storage to save changes.
     * @throws JohnException If an error occurs during execution.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws JohnException;
    
    /**
     * Checks if this command should exit the application.
     *
     * @return true if the application should exit, false otherwise.
     */
    public boolean isExit() {
        return false;
    }
}

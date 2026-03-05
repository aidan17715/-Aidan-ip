            /**
 * Represents a command to exit the application.
 */
public class ExitCommand extends Command {
    
    /**
     * Executes the exit command (does nothing as exit is handled by isExit()).
     *
     * @param tasks The task list (not used).
     * @param ui The UI (not used).
     * @param storage The storage (not used).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        // No action needed
    }
    
    /**
     * Indicates that this command should exit the application.
     *
     * @return true to signal the application should exit.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}

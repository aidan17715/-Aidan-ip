/**
 * Represents a command to list all tasks.
 */
public class ListCommand extends Command {
    
    /**
     * Executes the command to display all tasks in the list.
     *
     * @param tasks The task list to display.
     * @param ui The UI to display the task list.
     * @param storage The storage (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskList(tasks);
    }
}

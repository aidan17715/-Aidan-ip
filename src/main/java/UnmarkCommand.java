/**
 * Represents a command to mark a task as not done.
 */
public class UnmarkCommand extends Command {
    private int taskIndex;
    
    /**
     * Creates a new unmark command for the specified task.
     *
     * @param taskIndex The index of the task to mark as not done (0-based).
     */
    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }
    
    /**
     * Executes the command to mark a task as not done.
     *
     * @param tasks The task list containing the task to unmark.
     * @param ui The UI to display messages.
     * @param storage The storage to save the updated task list.
     * @throws JohnException If an error occurs during saving or if the task index is invalid.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JohnException {
        if (taskIndex < 0 || taskIndex >= tasks.getTaskCount()) {
            throw new JohnException("OOPS!!! That task number doesn't exist.");
        }
        Task task = tasks.getTask(taskIndex);
        task.markAsNotDone();
        ui.showTaskUnmarked(task);
        storage.save(tasks.getTasks());
    }
}

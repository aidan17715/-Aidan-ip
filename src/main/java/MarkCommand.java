/**
 * Represents a command to mark a task as done.
 */
public class MarkCommand extends Command {
    private int taskIndex;
    
    /**
     * Creates a new mark command for the specified task.
     *
     * @param taskIndex The index of the task to mark as done (0-based).
     */
    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }
    
    /**
     * Executes the command to mark a task as done.
     *
     * @param tasks The task list containing the task to mark.
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
        task.markAsDone();
        ui.showTaskMarked(task);
        storage.save(tasks.getTasks());
    }
}

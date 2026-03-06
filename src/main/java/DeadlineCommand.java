/**
 * Represents a command to add a deadline task.
 */
public class DeadlineCommand extends Command {
    private String description;
    private String by;
    
    /**
     * Creates a new deadline command with the given description and due date.
     *
     * @param description The description of the deadline task.
     * @param by The due date in yyyy-mm-dd format.
     */
    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }
    
    /**
     * Executes the command to add a deadline task to the list.
     *
     * @param tasks The task list to add the deadline to.
     * @param ui The UI to display messages.
     * @param storage The storage to save the updated task list.
     * @throws JohnException If an error occurs during saving or if the date format is invalid.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JohnException {
        Task task = new Deadline(description, by);
        tasks.addTask(task);
        ui.showTaskAdded(task, tasks.getTaskCount());
        storage.save(tasks.getTasks());
    }
}

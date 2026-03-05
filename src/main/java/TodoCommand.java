/**
 * Represents a command to add a todo task.
 */
public class TodoCommand extends Command {
    private String description;
    
    /**
     * Creates a new todo command with the given description.
     *
     * @param description The description of the todo task.
     */
    public TodoCommand(String description) {
        this.description = description;
    }
    
    /**
     * Executes the command to add a todo task to the list.
     *
     * @param tasks The task list to add the todo to.
     * @param ui The UI to display messages.
     * @param storage The storage to save the updated task list.
     * @throws JohnException If an error occurs during saving.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JohnException {
        Task task = new Todo(description);
        tasks.addTask(task);
        ui.showTaskAdded(task, tasks.getTaskCount());
        storage.save(tasks.getTasks());
    }
}

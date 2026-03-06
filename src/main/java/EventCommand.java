/**
 * Represents a command to add an event task.
 */
public class EventCommand extends Command {
    private String description;
    private String from;
    private String to;
    
    /**
     * Creates a new event command with the given description and time period.
     *
     * @param description The description of the event.
     * @param from The start date in yyyy-mm-dd format.
     * @param to The end date in yyyy-mm-dd format.
     */
    public EventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }
    
    /**
     * Executes the command to add an event task to the list.
     *
     * @param tasks The task list to add the event to.
     * @param ui The UI to display messages.
     * @param storage The storage to save the updated task list.
     * @throws JohnException If an error occurs during saving or if the date format is invalid.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JohnException {
        Task task = new Event(description, from, to);
        tasks.addTask(task);
        ui.showTaskAdded(task, tasks.getTaskCount());
        storage.save(tasks.getTasks());
    }
}

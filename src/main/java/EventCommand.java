public class EventCommand extends Command {
    private String description;
    private String from;
    private String to;
    
    public EventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }
    
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JohnException {
        Task task = new Event(description, from, to);
        tasks.addTask(task);
        ui.showTaskAdded(task, tasks.getTaskCount());
        storage.save(tasks.getTasks());
    }
}

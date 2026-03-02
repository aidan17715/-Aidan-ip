public class TodoCommand extends Command {
    private String description;
    
    public TodoCommand(String description) {
        this.description = description;
    }
    
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JohnException {
        Task task = new Todo(description);
        tasks.addTask(task);
        ui.showTaskAdded(task, tasks.getTaskCount());
        storage.save(tasks.getTasks());
    }
}

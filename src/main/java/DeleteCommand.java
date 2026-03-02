public class DeleteCommand extends Command {
    private int taskIndex;
    
    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }
    
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JohnException {
        Task task = tasks.getTask(taskIndex);
        tasks.deleteTask(taskIndex);
        ui.showTaskDeleted(task, tasks.getTaskCount());
        storage.save(tasks.getTasks());
    }
}

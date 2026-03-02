public class MarkCommand extends Command {
    private int taskIndex;
    
    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }
    
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JohnException {
        Task task = tasks.getTask(taskIndex);
        task.markAsDone();
        ui.showTaskMarked(task);
        storage.save(tasks.getTasks());
    }
}

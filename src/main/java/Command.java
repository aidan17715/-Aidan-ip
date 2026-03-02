public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws JohnException;
    
    public boolean isExit() {
        return false;
    }
}

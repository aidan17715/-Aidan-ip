import java.util.ArrayList;

/**
 * Represents a command to find tasks containing a keyword.
 */
public class FindCommand extends Command {
    
    private String keyword;
    
    /**
     * Creates a new find command with the given keyword.
     *
     * @param keyword The keyword to search for in task descriptions.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }
    
    /**
     * Executes the command to find and display matching tasks.
     *
     * @param tasks The task list to search in.
     * @param ui The UI to display matching tasks.
     * @param storage The storage (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        
        for (int i = 0; i < tasks.getTaskCount(); i++) {
            Task task = tasks.getTask(i);
            if (task.getDescription().contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        
        ui.showMatchingTasks(matchingTasks);
    }
}

import java.util.ArrayList;

/**
 * Manages a list of tasks.
 * Provides methods to add, delete, and retrieve tasks.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Creates an empty task list.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Creates a task list with pre-loaded tasks.
     *
     * @param loadedTasks The list of tasks to initialize with.
     */
    public TaskList(ArrayList<Task> loadedTasks) {
        this.tasks = new ArrayList<>(loadedTasks);
    }

    /**
     * Adds a task to the list.
     *
     * @param task The task to add.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Returns the task at the specified index.
     *
     * @param index The index of the task (0-based).
     * @return The task at the specified index.
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Deletes the task at the specified index.
     *
     * @param index The index of the task to delete (0-based).
     */
    public void deleteTask(int index) {
        tasks.remove(index);
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The number of tasks.
     */
    public int getTaskCount() {
        return tasks.size();
    }

    /**
     * Returns the list of all tasks.
     *
     * @return The ArrayList containing all tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}

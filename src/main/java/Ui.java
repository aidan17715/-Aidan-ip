import java.util.Scanner;
import java.util.ArrayList;

/**
 * Handles all user interactions and displays messages to the user.
 */
public class Ui {
    private static final String LINE = "____________________________________________________________";
    private Scanner scanner;
    
    /**
     * Creates a new Ui instance with a Scanner for reading user input.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Reads a command from the user.
     *
     * @return The command entered by the user.
     */
    public String readCommand() {
        return scanner.nextLine();
    }
    
    /**
     * Displays the welcome message to the user.
     */
    public void showWelcome() {
        System.out.println(LINE);
        System.out.println(" Good evening. I'm John");
        System.out.println(" What can I do for you?");
        System.out.println(LINE);
    }

    /**
     * Displays the goodbye message to the user.
     */
    public void showGoodbye() {
        System.out.println(LINE);
        System.out.println(" Thank you so much.");
        System.out.println(LINE);
    }

    /**
     * Displays a separator line.
     */
    public void showLine() {
        System.out.println(LINE);
    }

    /**
     * Displays a message confirming a task has been added.
     *
     * @param task The task that was added.
     * @param taskCount The total number of tasks in the list.
     */
    public void showTaskAdded(Task task, int taskCount) {
        System.out.println(" Okay. I've added this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " + taskCount + " tasks in the list.");
    }
    /**
     * Displays a message confirming a task has been deleted.
     *
     * @param task The task that was deleted.
     * @param taskCount The total number of tasks remaining in the list.
     */
    public void showTaskDeleted(Task task, int taskCount) {
        System.out.println(" Noted. I've removed this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " + taskCount + " tasks in the list.");
    }
    /**
     * Displays a message confirming a task has been marked as done.
     *
     * @param task The task that was marked as done.
     */
    public void showTaskMarked(Task task) {
        System.out.println(" Good. I've marked this task as done:");
        System.out.println("   " + task);
    }

    /**
     * Displays a message confirming a task has been marked as not done.
     *
     * @param task The task that was marked as not done.
     */
    public void showTaskUnmarked(Task task) {
        System.out.println(" Okay. I've marked this task as not done yet:");
        System.out.println("   " + task);
    }

    /**
     * Displays all tasks in the task list.
     *
     * @param taskList The task list to display.
     */
    public void showTaskList(TaskList taskList) {
        System.out.println(" Check this out. Here are the tasks in your list:");
        for (int i = 0; i < taskList.getTaskCount(); i++) {
            System.out.println(" " + (i + 1) + "." + taskList.getTask(i));
        }
    }

    /**
     * Displays tasks that match a search keyword.
     *
     * @param matchingTasks The list of matching tasks to display.
     */
    public void showMatchingTasks(ArrayList<Task> matchingTasks) {
        if (matchingTasks.isEmpty()) {
            System.out.println(" No matching tasks found.");
        } else {
            System.out.println(" Here are the matching tasks in your list:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println(" " + (i + 1) + "." + matchingTasks.get(i));
            }
        }
    }

    /**
     * Displays an error message to the user.
     *
     * @param message The error message to display.
     */
    public void showError(String message) {
        System.out.println(" " + message);
    }
}

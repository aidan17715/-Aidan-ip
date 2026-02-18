public class Ui {
    private static final String LINE = "____________________________________________________________";
    
    public void showWelcome() {
        System.out.println(LINE);
        System.out.println(" Good evening. I'm John");
        System.out.println(" What can I do for you?");
        System.out.println(LINE);
    }

    public void showGoodbye() {
        System.out.println(LINE);
        System.out.println(" Thank you so much.");
        System.out.println(LINE);
    }

    public void showLine() {
        System.out.println(LINE);
    }

    public void showTaskAdded(Task task, int taskCount) {
        System.out.println(" Okay. I've added this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " + taskCount + " tasks in the list.");
    }
    public void showTaskDeleted(Task task, int taskCount) {
        System.out.println(" Noted. I've removed this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " + taskCount + " tasks in the list.");
    }
    public void showTaskMarked(Task task) {
        System.out.println(" Good. I've marked this task as done:");
        System.out.println("   " + task);
    }

    public void showTaskUnmarked(Task task) {
        System.out.println(" Okay. I've marked this task as not done yet:");
        System.out.println("   " + task);
    }

    public void showTaskList(TaskList taskList) {
        System.out.println(" Check this out. Here are the tasks in your list:");
        for (int i = 0; i < taskList.getTaskCount(); i++) {
            System.out.println(" " + (i + 1) + "." + taskList.getTask(i));
        }
    }

    public void showError(String message) {
        System.out.println(" " + message);
    }
}

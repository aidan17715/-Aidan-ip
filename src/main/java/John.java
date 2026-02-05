import java.util.Scanner;

public class John {
    private TaskList tasks;
    private Ui ui;
    private Scanner scanner;

    public John() {
        this.tasks = new TaskList();
        this.ui = new Ui();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        ui.showWelcome();
        String input = scanner.nextLine();
        
        while (!input.equals("bye")) {
            ui.showLine();
            handleCommand(input);
            ui.showLine();
            input = scanner.nextLine();
        }
        
        ui.showGoodbye();
        scanner.close();
    }

    private void handleCommand(String input) {
        if (input.equals("list")) {
            handleList();
        } else if (input.startsWith("mark ")) {
            handleMark(input);
        } else if (input.startsWith("unmark ")) {
            handleUnmark(input);
        } else if (input.startsWith("todo ")) {
            handleTodo(input);
        } else if (input.startsWith("deadline ")) {
            handleDeadline(input);
        } else if (input.startsWith("event ")) {
            handleEvent(input);
        } else {
            ui.showError("I don't understand that command.");
        }
    }

    private void handleList() {
        ui.showTaskList(tasks);
    }

    private void handleMark(String input) {
        int taskIndex = Parser.getTaskIndex(input);
        Task task = tasks.getTask(taskIndex);
        task.markAsDone();
        ui.showTaskMarked(task);
    }

    private void handleUnmark(String input) {
        int taskIndex = Parser.getTaskIndex(input);
        Task task = tasks.getTask(taskIndex);
        task.markAsNotDone();
        ui.showTaskUnmarked(task);
    }

    private void handleTodo(String input) {
        String description = Parser.getTodoDescription(input);
        Task task = new Todo(description);
        tasks.addTask(task);
        ui.showTaskAdded(task, tasks.getTaskCount());
    }

    private void handleDeadline(String input) {
        String[] parts = Parser.parseDeadline(input);
        Task task = new Deadline(parts[0], parts[1]);
        tasks.addTask(task);
        ui.showTaskAdded(task, tasks.getTaskCount());
    }

    private void handleEvent(String input) {
        String[] parts = Parser.parseEvent(input);
        Task task = new Event(parts[0], parts[1], parts[2]);
        tasks.addTask(task);
        ui.showTaskAdded(task, tasks.getTaskCount());
    }

    public static void main(String[] args) {
        new John().run();
    }
}

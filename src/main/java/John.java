import java.util.Scanner;
import java.util.ArrayList;

public class John {
    private TaskList tasks;
    private Ui ui;
    private Scanner scanner;
    private Storage storage;

    public John(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        this.scanner = new Scanner(System.in);
        
        try {
            ArrayList<Task> loadedTasks = storage.load();
            this.tasks = new TaskList(loadedTasks);
        } catch (JohnException e) {
            ui.showError(e.getMessage());
            this.tasks = new TaskList();
        }
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

    private void saveTasksToFile() {
        try {
            storage.save(tasks.getTasks());
        } catch (JohnException e) {
            ui.showError(e.getMessage());
        }
    }

    private void handleCommand(String input) {
        try {
            if (input.equals("list")) {
                handleList();
            } else if (input.startsWith("mark")) {
                handleMark(input);
            } else if (input.startsWith("unmark")) {
                handleUnmark(input);
            } else if (input.startsWith("delete")) {
                handleDelete(input);
            } else if (input.startsWith("todo")) {
                handleTodo(input);
            } else if (input.startsWith("deadline")) {
                handleDeadline(input);
            } else if (input.startsWith("event")) {
                handleEvent(input);
            } else {
                throw new JohnException("OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        } catch (JohnException e) {
            ui.showError(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            ui.showError("OOPS!!! That task number doesn't exist.");
        }
    }

    private void handleList() {
        ui.showTaskList(tasks);
    }

    private void handleMark(String input) throws JohnException {
        int taskIndex = Parser.getTaskIndex(input);
        Task task = tasks.getTask(taskIndex);
        task.markAsDone();
        ui.showTaskMarked(task);
        saveTasksToFile();
    }

    private void handleUnmark(String input) throws JohnException {
        int taskIndex = Parser.getTaskIndex(input);
        Task task = tasks.getTask(taskIndex);
        task.markAsNotDone();
        ui.showTaskUnmarked(task);
        saveTasksToFile();
    }

    private void handleDelete(String input) throws JohnException {
        int taskIndex = Parser.getTaskIndex(input);
        Task task = tasks.getTask(taskIndex);
        tasks.deleteTask(taskIndex);
        ui.showTaskDeleted(task, tasks.getTaskCount());
    }

    private void handleTodo(String input) throws JohnException {
        String description = Parser.getTodoDescription(input);
        Task task = new Todo(description);
        tasks.addTask(task);
        ui.showTaskAdded(task, tasks.getTaskCount());
        saveTasksToFile();
    }

    private void handleDeadline(String input) throws JohnException {
        String[] parts = Parser.parseDeadline(input);
        Task task = new Deadline(parts[0], parts[1]);
        tasks.addTask(task);
        ui.showTaskAdded(task, tasks.getTaskCount());
        saveTasksToFile();
    }

    private void handleEvent(String input) throws JohnException {
        String[] parts = Parser.parseEvent(input);
        Task task = new Event(parts[0], parts[1], parts[2]);
        tasks.addTask(task);
        ui.showTaskAdded(task, tasks.getTaskCount());
        saveTasksToFile();
    }

    public static void main(String[] args) {
        new John("./data/john.txt").run();
    }
}

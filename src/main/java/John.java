import java.util.ArrayList;

/**
 * Main class for the John task management application.
 * John is a chatbot that helps users manage their tasks.
 */
public class John {
    private TaskList tasks;
    private Ui ui;
    private Storage storage;

    /**
     * Creates a new John instance with the specified storage file path.
     *
     * @param filePath The path to the file where tasks will be stored.
     */
    public John(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        
        try {
            ArrayList<Task> loadedTasks = storage.load();
            this.tasks = new TaskList(loadedTasks);
        } catch (JohnException e) {
            ui.showError(e.getMessage());
            this.tasks = new TaskList();
        }
    }

    /**
     * Runs the main command loop of the application.
     * Continuously reads and processes user commands until an exit command is given.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (JohnException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Main entry point of the application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        new John("./data/john.txt").run();
    }
}

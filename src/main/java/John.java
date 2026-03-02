import java.util.ArrayList;

public class John {
    private TaskList tasks;
    private Ui ui;
    private Storage storage;

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

    public static void main(String[] args) {
        new John("./data/john.txt").run();
    }
}

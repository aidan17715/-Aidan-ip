import java.util.ArrayList;

public class TaskList {
    private static final int MAX_TASKS = 100;
    private Task[] tasks;
    private int taskCount;

    public TaskList() {
        this.tasks = new Task[MAX_TASKS];
        this.taskCount = 0;
    }

    public TaskList(ArrayList<Task> loadedTasks) {
        this.tasks = new Task[MAX_TASKS];
        this.taskCount = 0;
        for (Task task : loadedTasks) {
            this.tasks[taskCount++] = task;
        }
    }

    public void addTask(Task task) {
        tasks[taskCount] = task;
        taskCount++;
    }

    public Task getTask(int index) {
        return tasks[index];
    }

    public int getTaskCount() {
        return taskCount;
    }

    public ArrayList<Task> getTasks() {
        ArrayList<Task> taskList = new ArrayList<>();
        for (int i = 0; i < taskCount; i++) {
            taskList.add(tasks[i]);
        }
        return taskList;
    }
}

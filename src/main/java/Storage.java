import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles loading and saving tasks to a file.
 */
public class Storage {
    private String filePath;

    /**
     * Creates a new Storage instance with the specified file path.
     *
     * @param filePath The path to the file where tasks will be stored.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from the storage file.
     *
     * @return An ArrayList of tasks loaded from the file.
     * @throws JohnException If an error occurs while reading from the file.
     */
    public ArrayList<Task> load() throws JohnException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        
        if (!file.exists()) {
            return tasks; // Return empty list if file doesn't exist
        }

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = parseTask(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
            scanner.close();
        } catch (IOException e) {
            throw new JohnException("OOPS!!! Error loading tasks from file.");
        }
        
        return tasks;
    }

    /**
     * Parses a line from the storage file into a Task object.
     *
     * @param line The line to parse.
     * @return The parsed Task, or null if the line is corrupted.
     */
    private Task parseTask(String line) {
        try {
            String[] parts = line.split(" \\| ");
            if (parts.length < 3) {
                return null; // Corrupted data, skip this line
            }
            
            String type = parts[0];
            boolean isDone = parts[1].equals("1");
            String description = parts[2];
            
            Task task = null;
            switch (type) {
            case "T":
                task = new Todo(description);
                break;
            case "D":
                if (parts.length >= 4) {
                    try {
                        task = new Deadline(description, parts[3]);
                    } catch (JohnException e) {
                        return null; // Invalid date format, skip this task
                    }
                }
                break;
            case "E":
                if (parts.length >= 5) {
                    try {
                        task = new Event(description, parts[3], parts[4]);
                    } catch (JohnException e) {
                        return null; // Invalid date format, skip this task
                    }
                }
                break;
            default:
                return null; // Unknown type, skip
            }
            
            if (task != null && isDone) {
                task.markAsDone();
            }
            
            return task;
        } catch (Exception e) {
            return null; // Corrupted data, skip this line
        }
    }

    /**
     * Saves the list of tasks to the storage file.
     *
     * @param tasks The ArrayList of tasks to save.
     * @throws JohnException If an error occurs while writing to the file.
     */
    public void save(ArrayList<Task> tasks) throws JohnException {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // Create directory if it doesn't exist
            
            FileWriter writer = new FileWriter(file);
            for (Task task : tasks) {
                writer.write(formatTask(task) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new JohnException("OOPS!!! Error saving tasks to file.");
        }
    }

    /**
     * Formats a task into a string for storage.
     *
     * @param task The task to format.
     * @return A formatted string representation of the task.
     */
    private String formatTask(Task task) {
        String type;
        String details = "";
        
        if (task instanceof Todo) {
            type = "T";
        } else if (task instanceof Deadline) {
            type = "D";
            details = " | " + ((Deadline) task).getBy(); // LocalDate will be converted to yyyy-MM-dd format
        } else if (task instanceof Event) {
            type = "E";
            Event event = (Event) task;
            details = " | " + event.getFrom() + " | " + event.getTo(); // LocalDate will be converted to yyyy-MM-dd format
        } else {
            type = "T"; // Default
        }
        
        int isDone = task.isDone ? 1 : 0;
        return type + " | " + isDone + " | " + task.getDescription() + details;
    }
}

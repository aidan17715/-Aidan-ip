public class Parser {
    
    public static String getCommand(String input) {
        String[] parts = input.split(" ", 2);
        return parts[0];
    }

    public static int getTaskIndex(String input) throws JohnException {
        String[] parts = input.split(" ");
        if (parts.length < 2) {
            throw new JohnException("OOPS!!! Please specify which task to mark.");
        }
        try {
            return Integer.parseInt(parts[1]) - 1;
        } catch (NumberFormatException e) {
            throw new JohnException("OOPS!!! Task number must be a valid number.");
        }
    }

    public static String getTodoDescription(String input) throws JohnException {
        if (input.trim().equals("todo")) {
            throw new JohnException("OOPS!!! The description of a todo cannot be empty.");
        }
        return input.substring(5).trim();
    }

    public static String[] parseDeadline(String input) throws JohnException {
        if (input.trim().equals("deadline")) {
            throw new JohnException("OOPS!!! The description of a deadline cannot be empty.");
        }
        String details = input.substring(9);
        int byIndex = details.indexOf(" /by ");
        if (byIndex == -1) {
            throw new JohnException("OOPS!!! Please specify the deadline with /by.");
        }
        String description = details.substring(0, byIndex).trim();
        String by = details.substring(byIndex + 5).trim();
        if (description.isEmpty()) {
            throw new JohnException("OOPS!!! The description of a deadline cannot be empty.");
        }
        if (by.isEmpty()) {
            throw new JohnException("OOPS!!! The deadline date/time cannot be empty.");
        }
        return new String[]{description, by};
    }

    public static String[] parseEvent(String input) throws JohnException {
        if (input.trim().equals("event")) {
            throw new JohnException("OOPS!!! The description of an event cannot be empty.");
        }
        String details = input.substring(6);
        int fromIndex = details.indexOf(" /from ");
        int toIndex = details.indexOf(" /to ");
        if (fromIndex == -1 || toIndex == -1) {
            throw new JohnException("OOPS!!! Please specify the event time with /from and /to.");
        }
        String description = details.substring(0, fromIndex).trim();
        String from = details.substring(fromIndex + 7, toIndex).trim();
        String to = details.substring(toIndex + 5).trim();
        if (description.isEmpty()) {
            throw new JohnException("OOPS!!! The description of an event cannot be empty.");
        }
        if (from.isEmpty() || to.isEmpty()) {
            throw new JohnException("OOPS!!! The event time cannot be empty.");
        }
        return new String[]{description, from, to};
    }
}

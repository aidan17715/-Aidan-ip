public class Parser {
    
    public static Command parse(String fullCommand) throws JohnException {
        String input = fullCommand.trim();
        
        if (input.equals("list")) {
            return new ListCommand();
        } else if (input.equals("bye")) {
            return new ExitCommand();
        } else if (input.startsWith("mark ")) {
            int taskIndex = getTaskIndex(input);
            return new MarkCommand(taskIndex);
        } else if (input.startsWith("unmark ")) {
            int taskIndex = getTaskIndex(input);
            return new UnmarkCommand(taskIndex);
        } else if (input.startsWith("delete ")) {
            int taskIndex = getTaskIndex(input);
            return new DeleteCommand(taskIndex);
        } else if (input.startsWith("todo")) {
            String description = getTodoDescription(input);
            return new TodoCommand(description);
        } else if (input.startsWith("deadline")) {
            String[] parts = parseDeadline(input);
            return new DeadlineCommand(parts[0], parts[1]);
        } else if (input.startsWith("event")) {
            String[] parts = parseEvent(input);
            return new EventCommand(parts[0], parts[1], parts[2]);
        } else if (input.startsWith("find ")) {
            String keyword = getFindKeyword(input);
            return new FindCommand(keyword);
        } else {
            throw new JohnException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

    private static int getTaskIndex(String input) throws JohnException {
        String[] parts = input.split(" ");
        if (parts.length < 2) {
            throw new JohnException("OOPS!!! Please specify which task.");
        }
        try {
            return Integer.parseInt(parts[1]) - 1;
        } catch (NumberFormatException e) {
            throw new JohnException("OOPS!!! Task number must be a valid number.");
        }
    }

    private static String getTodoDescription(String input) throws JohnException {
        if (input.trim().equals("todo")) {
            throw new JohnException("OOPS!!! The description of a todo cannot be empty.");
        }
        return input.substring(5).trim();
    }

    private static String[] parseDeadline(String input) throws JohnException {
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

    private static String[] parseEvent(String input) throws JohnException {
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

    private static String getFindKeyword(String input) throws JohnException {
        if (input.trim().equals("find")) {
            throw new JohnException("OOPS!!! Please specify a keyword to search for.");
        }
        return input.substring(5).trim();
    }
}

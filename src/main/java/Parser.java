public class Parser {
    
    public static String getCommand(String input) {
        String[] parts = input.split(" ", 2);
        return parts[0];
    }

    public static int getTaskIndex(String input) {
        String[] parts = input.split(" ");
        return Integer.parseInt(parts[1]) - 1;
    }

    public static String getTodoDescription(String input) {
        return input.substring(5);
    }

    public static String[] parseDeadline(String input) {
        String details = input.substring(9);
        int byIndex = details.indexOf(" /by ");
        String description = details.substring(0, byIndex);
        String by = details.substring(byIndex + 5);
        return new String[]{description, by};
    }

    public static String[] parseEvent(String input) {
        String details = input.substring(6);
        int fromIndex = details.indexOf(" /from ");
        int toIndex = details.indexOf(" /to ");
        String description = details.substring(0, fromIndex);
        String from = details.substring(fromIndex + 7, toIndex);
        String to = details.substring(toIndex + 5);
        return new String[]{description, from, to};
    }
}

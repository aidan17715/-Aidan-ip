import java.util.Scanner;

public class John {
    public static void main(String[] args) {
        String logo = "     _       _           \n"
                + "    | | ___ | |__  _ __  \n"
                + " _  | |/ _ \\| '_ \\| '_ \\ \n"
                + "| |_| | (_) | | | | | | |\n"
                + " \\___/ \\___/|_| |_|_| |_|\n";
        
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm John");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
        
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        while (!input.equals("bye")) {
            System.out.println("____________________________________________________________");
            System.out.println(" " + input);
            System.out.println("____________________________________________________________");
            input = scanner.nextLine();
        }
        
        System.out.println("____________________________________________________________");
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
        
        scanner.close();
    }
}

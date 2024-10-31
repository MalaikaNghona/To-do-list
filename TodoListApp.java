import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    private ArrayList<String> tasks;

    public TodoListApp() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Your To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        TodoListApp todoList = new TodoListApp();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the To-Do List App!");
        do {
            System.out.println("\nAvailable commands: add, remove, view, exit");
            System.out.print("Enter a command: ");
            command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Enter a task: ");
                    String task = scanner.nextLine();
                    todoList.addTask(task);
                    break;

                case "remove":
                    System.out.print("Enter task number to remove: ");
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    todoList.removeTask(taskNumber - 1);
                    break;

                case "view":
                    todoList.viewTasks();
                    break;

                case "exit":
                    System.out.println("Exiting the app. Goodbye!");
                    break;

                default:
                    System.out.println("Unknown command. Please try again.");
            }
        } while (!command.equals("exit"));

        scanner.close();
    }
}
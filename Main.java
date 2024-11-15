package fundamentals.cmd_todolist;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static String[] tasks = new String[0];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cmd;

        System.out.println("CMD todo app");
        System.out.println("Type 'help' to view all comands list or 'exit' to quit.");

        String regex = "(list)|create ([^>]+)|update --name ([^>]+) --id ([^>]+)|delete --id ([^>]+)|(help)";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            System.out.print("> ");
            cmd = scanner.nextLine();

            if (cmd.equalsIgnoreCase("exit")) {
                System.out.println("Exiting CMD todo app. Goodbye!");
                break;
            }

            Matcher matcher = pattern.matcher(cmd);

            if (matcher.find()) {
                // list all todo tasks
                if (matcher.group(1) != null) {
                    read();
                }

                // create a new todo task
                if (matcher.group(2) != null) {
                    create(matcher.group(2));
                }

                // update the task
                if (matcher.group(3) != null && matcher.group(4) != null) {
                    update(matcher.group(3), Integer.parseInt(matcher.group(4)));
                }

                // delete the task
                if (matcher.group(5) != null) {
                    delete(Integer.parseInt(matcher.group(5)));
                }

                // help commands
                if (matcher.group(6) != null) {
                    helpCommands();
                }
            } else {
                System.out.println("Invalid command. Type 'help' to the view command list");
            }
        }

        scanner.close();
    }

    static void create(String taskName) {
        String[] newTasks = new String[tasks.length + 1];
        System.arraycopy(tasks, 0, newTasks, 0, tasks.length);
        newTasks[tasks.length] = taskName;
        tasks = newTasks;

        System.out.println();
        read();
    }

    static void update(String taskName, int taskId) {
        tasks[taskId] = taskName;
        System.out.println();
        read();
    }

    static void delete(int taskId) {
        String[] newTasks = new String[tasks.length - 1];
        System.arraycopy(tasks, 0, newTasks, 0, taskId);
        System.arraycopy(tasks, taskId + 1, newTasks, taskId, tasks.length - taskId - 1);
        tasks = newTasks;
        System.out.println();
        read();
    }

    static void read() {
        if (tasks.length <= 0) {
            System.out.println("No tasks foud");
            return;
        }

        for (int i = 0; i < tasks.length; i++) {
            System.out.println(i + "-" + tasks[i]);
        }
        System.out.println();
    }

    static void helpCommands() {
        System.out.println("Available commands:");
        System.out.println("  list                 - List all tasks");
        System.out.println("  create <task_name>   - Create a new task");
        System.out.println("  update --name <new_name> --id <task_id> - Update a task");
        System.out.println("  delete --id <task_id> - Delete a task");
        System.out.println("  help                 - Show this help message");
        System.out.println("  exit                 - Exit the program");
    }
}
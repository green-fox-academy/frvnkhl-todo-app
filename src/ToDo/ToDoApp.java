package ToDo;

import java.io.IOException;
import java.nio.file.Path;

public class ToDoApp {

    public void appStart(String[] args) throws IOException {
        TaskList taskList = new TaskList();
        FileHandler f = new FileHandler(Path.of("todos.txt"));
        String input = args[0];
        Writer w = new Writer();

        switch (input) {
            case "-l":
                taskList.updateTasks(f);
                if (taskList.getTaskList().size() != 0) {
                    taskList.printAll();
                } else {
                    System.out.println("No todos for today! :)");
                }
                break;

            case "-a":
                if (args.length > 1) {
                    String task = args[1];
                    taskList.add(new Task(task));
                    System.out.println("Task added (:");
                } else {
                    System.err.println("Unable to add, no task provided");
                }
                break;

            case "-r":
                if (args.length > 1) {
                    taskList.updateTasks(f);
                    try {
                        int taskNum = Integer.parseInt(args[1]);
                        if (taskNum <= taskList.getTaskList().size()) {
                            taskList.removeTask(taskNum);
                            System.out.println("Task No" + taskNum + " removed");
                        } else {
                            System.err.println("Unable to remove: index is out of bound");
                        }
                    } catch (NumberFormatException n) {
                        System.err.println("Unable to remove: index is not a number");
                    }
                } else {
                    System.err.println("Unable to remove: no index provided");
                }
                break;

            case "-c":
                if (args.length > 1) {
                    taskList.updateTasks(f);
                    try {
                        int taskNum = Integer.parseInt(args[1]);
                        if (taskNum <= taskList.getTaskList().size()) {
                            taskList.completeTaskInAList(taskNum - 1);
                            System.out.println("Task No" + taskNum + " completed");
                        } else {
                            System.err.println("Unable to complete: index is out of bound");
                        }
                    } catch (NumberFormatException n) {
                        System.err.println("Unable to complete: index is not a number");
                    }
                } else {
                    System.err.println("Unable to remove: no index provided");
                }
                break;

            default:
                System.err.println("Unsupported Argument");
                w.homeScreen();

        }
    }


}

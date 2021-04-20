package ToDo;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
            appStart(args);
    }

    public static void appStart(String[] args) {
        Scanner s = new Scanner(System.in);
        TaskList taskList = new TaskList();
        int taskListLength = taskList.getTaskList().size();
        Writer w = new Writer();
        FileHandler f = new FileHandler(Path.of("todos.txt"));
        System.out.println(w.homeScreen());


        switch (args[0]) {
            case "-l":
                taskList.updateTasks(f);
                if (taskList.getTaskList().size() != 0) {
                    taskList.printAll();
                } else {
                    System.out.println("No todos for today! :)");
                }

            case "-a":


            case "-r":


            case "-c":


        }
    }


}

package ToDo;

public class ToDoApp {
    public static void main(String[] args) {
        String[] stringArgs = {"  Lists all the tasks", "  Adds a new task", "  Removes a task", "  Completes a task"};

        System.out.println("Command Line Todo application");
        System.out.println("=============================");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i] + stringArgs[i]);
        }
    }


}

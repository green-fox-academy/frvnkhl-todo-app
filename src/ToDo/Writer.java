package ToDo;

public class Writer {

    public String homeScreen() {
        String intro = "Command Line Todo application\n=============================\n";
        String[] stringArgs = {"-l  Lists all the tasks", "-a  Adds a new task", "-r  Removes a task", "-c  Completes a task"};
        StringBuilder arguments = new StringBuilder();
        for (String s : stringArgs) {
            arguments.append(s).append("\n");
        }
        return intro + arguments;
    }
}

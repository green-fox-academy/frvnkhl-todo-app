package ToDo;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> taskList = new ArrayList<>();

    public void add(Task task) {
        taskList.add(task);
    }

    public List<String> printAll() {
        List<String> printingTasks = new ArrayList<>();
        for (Task task : taskList) {
            int taskListIndex = taskList.indexOf(task) + 1;
            printingTasks.add(taskListIndex + " - [" + task.checkCompletion() + "] " + task.getTaskDescription());
        }
        return printingTasks;
    }

    public List<Task> getTaskList() {
        return taskList;
    }
}

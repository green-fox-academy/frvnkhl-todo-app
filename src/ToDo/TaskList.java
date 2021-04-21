package ToDo;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> taskList = new ArrayList<>();

    public void add(Task task) throws IOException {
        FileHandler f = new FileHandler(Path.of("todos.txt"));
        taskList.add(task);
        f.updateTheFile(task.getTaskDescription());
    }

    public void removeTask(int i) throws IOException {
        FileHandler f = new FileHandler(Path.of("todos.txt"));
        taskList.remove(i-1);
        f.removeTheLine(i);
    }

    public void updateTasks(FileHandler f) {
        List<String> fileLines = f.readTheFile();
        for (String s : fileLines) {
            Task t = new Task(s);
            if(!taskList.contains(t)) {
                taskList.add(new Task(s));
            }
        }
    }

        public void printAll () {
            for (Task task : taskList) {
                int taskListIndex = taskList.indexOf(task) + 1;
                System.out.println(taskListIndex + " - [" + task.checkCompletion() + "] " + task.getTaskDescription());
            }

        }


    public List<Task> getTaskList() {
        return taskList;
    }
}

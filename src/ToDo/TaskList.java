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
        f.updateTheFile("[" + task.checkCompletion() + "]  " + task.getTaskDescription());
    }

    public void completeTaskInAList(int i) throws IOException {
        FileHandler f = new FileHandler(Path.of("todos.txt"));
        Task checkedTask = taskList.get(i);
        checkedTask.setCompleted(true);
        String newLine = "[" + checkedTask.checkCompletion() + "]  " + checkedTask.getTaskDescription();
        f.updateATask(i, newLine);
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
            String[] checkCompletion = s.split("  ");
            if(!taskList.contains(t)) {
                Task newTask = new Task(checkCompletion[1]);
                if (checkCompletion[0].charAt(1) == 'x') {
                    newTask.setCompleted(true);
                }
                taskList.add(newTask);
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

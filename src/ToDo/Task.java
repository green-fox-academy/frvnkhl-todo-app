package ToDo;

public class Task {

    private String taskDescription;
    private boolean completed;

    public Task (String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public char checkCompletion() {
        if(completed) {
            return 'x';
        } else {
            return ' ';
        }
    }
}

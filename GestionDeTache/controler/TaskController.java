package controler;

import model.Task;
import model.TaskManager;
import java.io.IOException;
import java.util.List;

public class TaskController {
    private TaskManager taskManager;

    public TaskController() {
        taskManager = new TaskManager();
    }

    public void addTask(String description) {
        taskManager.addTask(description);
    }

    public void removeTask(int index) {
        taskManager.removeTask(index);
    }

    public List<Task> getTasks() {
        return taskManager.getTasks();
    }

    public void saveTasks(String filename) throws IOException {
        taskManager.saveTasksToFile(filename);
    }

    public void loadTasks(String filename) throws IOException {
        taskManager.loadTasksFromFile(filename);
    }
}

package model;
import java.io.*;
import java.util.*;
public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void saveTasksToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Task task : tasks) {
                writer.write(task.getDescription() + "," + task.isCompleted());
                writer.newLine();
            }
        }
    }

    public void loadTasksFromFile(String filename) throws IOException {
        tasks.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Task task = new Task(parts[0]);
                if (Boolean.parseBoolean(parts[1])) {
                    task.toggleCompleted();
                }
                tasks.add(task);
            }
        }
    }
}

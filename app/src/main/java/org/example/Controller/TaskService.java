package Controller;

import java.util.HashMap;
import java.util.Map;

import Model.Task;

public class TaskService {
    private Map<String, Task> tasks = new HashMap<String, Task>();
    public TaskService() {
        //read tassk from file
    }

    public void showAllTasks() {
        if(tasks.isEmpty()) {
           System.out.println("There are no tasks available!");
           return;
        }

        for(Task task:tasks.values()) {
            System.out.println(task.getId() + ": " + task.toString());
        }
    }

    public void addTask(String name, String description) {
        Task task = new Task(name, description);
        tasks.put(task.getId(), task);
    }

    public boolean toggleTaskComplete(String id) {
        if(tasks.containsKey(id)) {
            Task task = tasks.get(id);
            task.setCompleted(!task.isCompleted());
            return true;
        }

        return false;
    }

    public boolean modifyTask(String id, String name, String desc) {
        if(tasks.containsKey(id)) {
            Task task = tasks.get(id);
            task.setName(name);
            task.setDescription(desc);
            return true;
        }

        return false;
    }

    public boolean deleteTask(String id) {
        if(tasks.containsKey(id)) {
            tasks.remove(id);
            return true;
        }

        return false;
    }
}
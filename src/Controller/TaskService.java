package Controller;

import java.util.HashMap;
import java.util.Map;

import Model.Task;

public class TaskService {
    private Map<String, Task> tasks = new HashMap<String, Task>();
    public TaskService() {
        //read tassk from file
    }

    public void addTask(String name, String description) {
        Task task = new Task(name, description);
        tasks.put(task.getId(), task);
    }

    public boolean toggleTaskComplete(int index) {
        if(index < 1 || index > tasks.size()) {
            return false;
        }

        Task task = tasks.get(getTaskIdByIndex(index));

        if(task != null) {
            task.setCompleted(!task.isCompleted());
            return true;
        }

        return false;
    }

    public void showAllTasks() {
        if(tasks.isEmpty()) {
           System.out.println("There are no tasks available!");
           return;
        }

        int index = 1;        
        for(Task task:tasks.values()) {
            System.out.println(index + ". " + task.toString());
        }
    }

    public boolean deleteTaskByIndex(int index) {
        if(index < 1 || index > tasks.size()) {
            return false;
        }

        String taskId = getTaskIdByIndex(index);

        if(taskId != null) {
            tasks.remove(taskId);
            return true;
        }

        return false;
    }

    private String getTaskIdByIndex(int index) {
        int currentIndex = 1;
        for(String TaskId:tasks.keySet()) {
            if(currentIndex == index) {
                return TaskId;
            }
            currentIndex += 1;
        }
        return null;
    }
}
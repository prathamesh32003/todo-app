package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Task;

public class TaskService {
    private List<Task> tasks = new ArrayList<Task>();

    public TaskService() {
        //read tassk from file
    }

    void addTask(String name, String description) {
        Task task = new Task(name, description);
        tasks.add(task);
    }
}

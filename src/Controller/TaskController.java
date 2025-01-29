package Controller;

public class TaskController {
    private TaskService taskService;

    public TaskController() {
        this.taskService = new TaskService();
    }

    public boolean addTask(String name, String description) {
        if(name == null || name.trim().isEmpty()) {
            System.out.println("Cannot add task, name cannot be empty!");
            return false;
        }
        taskService.addTask(name, description);
        return true;
    }
}

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

    public boolean toggleTaskComplete(int index) {
        boolean isToggled = taskService.toggleTaskComplete(index);

        if(!isToggled) {
            System.out.println("Error toggling task!");
            return false;
        }
        return true;
    }

    public boolean deleteTaskByIndex(int index) {
        boolean isDeleted = taskService.deleteTaskByIndex(index);

        if(!isDeleted) {
            System.out.println("Error deleting task!");
            return false;
        }
        return true;
    }

    public void showAllTasks() {
        taskService.showAllTasks();
    }
}

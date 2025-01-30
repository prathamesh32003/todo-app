package org.example.Controller;

public class TaskController {
    private TaskService taskService;

    public TaskController() {
        this.taskService = new TaskService();
    }

    public void showAllTasks() {
        taskService.showAllTasks();
    }

    public boolean addTask(String name, String description) {
        if(name == null || name.trim().isEmpty()) {
            System.out.println("Cannot add task, name cannot be empty!");
            return false;
        }
        taskService.addTask(name, description);
        return true;
    }

    public boolean toggleTaskComplete(String id) {
        boolean isToggled = taskService.toggleTaskComplete(id);

        if(!isToggled) {
            System.out.println("Error toggling task!");
            return false;
        }
        return true;
    }

    public boolean modifyTask(String id, String name, String desc) {
        boolean isModified = taskService.modifyTask(id, name, desc);

        if(!isModified) {
            System.out.println("Error modifying task!");
            return false;
        }
        return true;
    }

    public boolean deleteTaskByIndex(String id) {
        boolean isDeleted = taskService.deleteTask(id);

        if(!isDeleted) {
            System.out.println("Error deleting task!");
            return false;
        }
        return true;
    }

    public boolean saveToFile() {
        boolean isSaved = taskService.saveToFile();

        if(!isSaved) {
            System.out.println("Error writing file!");
            return false;
        }
        return true;
    }
}

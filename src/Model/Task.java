package Model;

public class Task {
    private String name, description;
    private boolean isCompleted;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        isCompleted = false;
    }

    //getters and setters
    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    boolean isCompleted() {
        return isCompleted;
    }

    void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return name + (isCompleted ? "✓" : "X");
    }
}
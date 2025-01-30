package org.example.Model;

import java.util.UUID;

public class Task {
    private String id, name, description;
    private boolean isCompleted;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        isCompleted = false;
        id = UUID.randomUUID().toString();
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return (isCompleted ? "✓" : "X") + ": " + name +": " + description;
    }
}
package org.example.Controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.example.Model.Task;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TaskService {
    private Map<String, Task> tasks = new HashMap<String, Task>();
    private File saveFile;
    private boolean isDirty = false;
    private ScheduledExecutorService executorService;

    public TaskService() {
        saveFile = new File(System.getProperty("user.home"), ".tasks.json");

        if(!saveFile.exists()) {
            try {
                saveFile.createNewFile();
            } catch(IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            loadFromFile();
        }

        executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(autoSave, 0, 10, TimeUnit.SECONDS);
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
        saveToFile();
    }

    public boolean toggleTaskComplete(String id) {
        if(tasks.containsKey(id)) {
            Task task = tasks.get(id);
            task.setCompleted(!task.isCompleted());
            isDirty = true;
            return true;
        }

        return false;
    }

    public boolean modifyTask(String id, String name, String desc) {
        if(tasks.containsKey(id)) {
            Task task = tasks.get(id);
            task.setName(name);
            task.setDescription(desc);
            isDirty = true;
            return true;
        }

        return false;
    }

    public boolean deleteTask(String id) {
        if(tasks.containsKey(id)) {
            tasks.remove(id);
            saveToFile();
            return true;
        }

        return false;
    }

    public boolean saveToFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter fileWriter = new FileWriter(saveFile);
            fileWriter.write(gson.toJson(tasks.values()));
            fileWriter.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    private void loadFromFile() {
        Gson gson = new Gson();
        Type taskListType = new TypeToken<List<Task>>() {}.getType();

        try(FileReader fileReader = new FileReader(saveFile)) {
            if(saveFile.length() == 0) {
                return;
            }

            List<Task> taskList = gson.fromJson(fileReader, taskListType);

            if(taskList != null) {
                for(Task task:taskList) {
                    tasks.put(task.getId(), task);
                }
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    Runnable autoSave = new Runnable() {
        public void run() {
            if(isDirty) {
                saveToFile();
                isDirty = false;
            }
        }
    };
}
import java.util.Scanner;

import Controller.TaskController;

public class Main {
    public static void main(String[] args) {
        TaskController tc = new TaskController();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Task Name");
        String name = sc.nextLine();

        System.out.println("Enter Task Description");
        String desc = sc.nextLine();

        if(tc.addTask(name, desc)) {
            System.out.println("Task added successfully");
        }
    }
    
}

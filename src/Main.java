import java.util.Scanner;

import Controller.TaskController;

public class Main {
    static TaskController tc;
        public static void main(String[] args) {
        tc = new TaskController();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("1. Add New Task 2. Toggle Task 3. Show all Tasks 4. Delete Task");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    addTask();
                    break;
                
                case 2:
                    toggleTaskComplete();
                    break;
                
                case 3:
                    tc.showAllTasks();
                    break;
                
                case 4:
                    deleteTask();
                    break;
            
                default:
                    System.out.println("Wrong choice!");;
            }
        }
    }

    static void addTask() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name of the todo: ");
        String name = sc.nextLine();

        System.out.println("Enter description: ");
        String desc = sc.nextLine();

        tc.addTask(name, desc);
    }

    static void toggleTaskComplete() {
        Scanner sc = new Scanner(System.in);

        tc.showAllTasks();
        System.out.println("Enter the ID of the task: ");
        int index = sc.nextInt();

        tc.toggleTaskComplete(index);
    }

    static void deleteTask() {
        Scanner sc = new Scanner(System.in);

        tc.showAllTasks();
        System.out.println("Enter the ID of the task: ");
        int index = sc.nextInt();

        tc.deleteTaskByIndex(index);
    }
}

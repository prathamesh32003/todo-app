import java.util.Scanner;

import Controller.TaskController;

public class Main {
    static TaskController tc;
        public static void main(String[] args) {
        tc = new TaskController();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("1. Show All Tasks 2. Add a New Task 3. Modify a Task 4. Toggle a Task 5. Delete a Task");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    tc.showAllTasks();
                    break;
                
                case 2:
                    addTask();;
                    break;
                
                case 3:
                    modifyTask();
                    break;
                
                case 4:
                    toggleTaskComplete();
                    break;
                
                case 5:
                    deleteTask();;
                    break;
            
                default:
                    System.out.println("Wrong choice!");
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
        String id = sc.nextLine();

        tc.toggleTaskComplete(id);
    }

    static void deleteTask() {
        Scanner sc = new Scanner(System.in);

        tc.showAllTasks();
        System.out.println("Enter the ID of the task: ");
        String id = sc.nextLine();

        tc.deleteTaskByIndex(id);
    }

    static void modifyTask() {
        Scanner sc = new Scanner(System.in);
        String id, name, desc;

        tc.showAllTasks();

        System.out.println("Enter the ID of the task you want to modify: ");
        id = sc.nextLine();

        System.out.println("Enter the new name of the task: ");
        name = sc.nextLine();

        System.out.println("Enter the new description of the task: ");
        desc = sc.nextLine();

        tc.modifyTask(id, name, desc);
    }
}

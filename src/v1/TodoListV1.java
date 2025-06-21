package v1;

import domain.Todo;

import java.util.ArrayList;
import java.util.Scanner;


public class TodoListV1 {
    public static void main(String[] args) {
        boolean exit = true;
        Todo task = new Todo();
        ArrayList<Todo> arrTasks = null;
        TaskManage tm = new TaskManage();

        Scanner input = new Scanner(System.in);

        while(exit){
            System.out.println("\n===== select function =====");
            System.out.println("1. Add task / 2. Read task / 3. check / 4. Read all task / 5. Delete task / 6. exit");

            switch (input.nextInt()){
                case 1: //add
                    arrTasks = tm.addTask();
                    break;
                case 2: //read
                    int index = tm.readTask(arrTasks);
                    System.out.println("=== " + arrTasks.get(index).getId() + "의 todoList ===");
                    System.out.println("id: " + arrTasks.get(index).getId());
                    System.out.println("title: " + arrTasks.get(index).getTitle());
                    System.out.println("완료 여부: " + (arrTasks.get(index).isCompleted()?"완료":"미완료"));
                    System.out.println("created Time: " + arrTasks.get(index).getCreatedAt());
                    System.out.println("updated Time: " + arrTasks.get(index).getUpdatedAt());
                    break;
                case 3: //check
                    tm.check(arrTasks);
                    break;
                case 4: //readAll
                    tm.readAllTask(arrTasks);
                    break;
                case 5: //delete
                    tm.deleteTask(arrTasks);
                    break;
                case 6: //exit
                    exit = false;
                    break;
                default:
                    System.out.println("retry");
                    break;
            }

        }

    }

}

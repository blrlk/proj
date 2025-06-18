package todoList;

import java.util.ArrayList;
import java.util.Scanner;


public class todoList {
    public static void main(String[] args) {
        boolean exit = true;
        todo task = new todo();
        ArrayList<todo> arrTasks = null;
        taskManage tm = new taskManage();

        Scanner input = new Scanner(System.in);

        while(exit){
            System.out.println("\n===== select function =====");
            System.out.println("1. Add task / 2. Read task / 3. check / 4. Read all task / 5. Delete task / 6. exit");

            switch (input.nextInt()){
                case 1: //add
                    arrTasks = tm.addTask();
                    for(int  i=0;i<arrTasks.size();i++){
                        todo task1 = arrTasks.get(i);
                        System.out.println(task1.toString());
                    }
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

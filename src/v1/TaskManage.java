package v1;

import domain.Todo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManage {
    ArrayList<Todo> arrTasks  = new ArrayList<Todo>();
    Scanner input = new Scanner(System.in);

    public ArrayList<Todo> addTask(){
        while(true){
            Todo task = new Todo();

            System.out.println("id");
            String id = input.nextLine();
            if(id.isEmpty()){
                break;
            }
            int newId = Integer.parseInt(id);
            task.setId(newId);

            System.out.println("title");
            String title = input.nextLine();
            task.setTitle(title);

            LocalDateTime localDate = LocalDateTime.now();
            task.setCreatedAt(localDate);

            arrTasks.add(task);
        }

        return arrTasks;

    }

    public int readTask(ArrayList<Todo> arrTasks){
        while(true){
            System.out.println("select task");
            for(int i=0;i<arrTasks.size();i++){
                System.out.println(arrTasks.get(i).getId());
            }
            int id = Integer.parseInt(input.nextLine());

            int findId=0;
            for(int j=0;j<arrTasks.size();j++){
                if(arrTasks.get(j).getId() == id){
                    findId = j;
                    break;
                } else{
                    findId = -1;
                }
            }

            if(findId == -1){
                System.out.println("no such id");
                continue;
            } else{
                return findId;
            }

        }

    }

    public void check(ArrayList<Todo> arrTasks){
            int index = readTask(arrTasks);
        while(true) {
            System.out.println("상태 업데이트 할래? (y/n)");
            String answer = input.nextLine();
            Todo now = arrTasks.get(index);
            boolean crntState = now.isCompleted();

            if (answer.equals("y")) {
                now.setCompleted(!crntState);
                LocalDateTime localDate = LocalDateTime.now();
                now.setUpdatedAt(localDate);
                break;
            } else if(answer.equals("n")) {
                break;
            } else{
                System.out.println("다시");
                continue;
            }
        }

        System.out.println("update success");

    }

    public void readAllTask(ArrayList<Todo> arrTasks){
        for(int i=0;i<arrTasks.size();i++){
            Todo task = arrTasks.get(i);
            System.out.println(task.toString());
        }

    }

    public void deleteTask(ArrayList<Todo> arrTasks){
        int index = readTask(arrTasks);
        arrTasks.remove(index);
        System.out.println("delete success");
    }
}

package todoList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class taskManage {
    ArrayList<todo> arrTasks  = new ArrayList<todo>();
    Scanner input = new Scanner(System.in);

    public ArrayList<todo> addTask(){
        while(true){
            todo task = new todo();

            System.out.println("id");
            String id = input.nextLine();
            if(id.isEmpty()){
                break;
            }
            task.setId(id);

            System.out.println("title");
            String title = input.nextLine();
            task.setTitle(title);

            LocalDateTime localDate = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String createdTime = localDate.format(formatter);
            task.setCreatedAt(createdTime);

            arrTasks.add(task);
        }

        return arrTasks;

    }

    public int readTask(ArrayList<todo> arrTasks){
        while(true){
            System.out.println("select task");
            for(int i=0;i<arrTasks.size();i++){
                System.out.println(arrTasks.get(i).getId());
            }
            String id = input.nextLine();

            int findId=0;
            for(int j=0;j<arrTasks.size();j++){
                if(arrTasks.get(j).getId().equals(id)){
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

    public void check(ArrayList<todo> arrTasks){
            int index = readTask(arrTasks);
        while(true) {
            System.out.println("상태 업데이트 할래? (y/n)");
            String answer = input.nextLine();
            todo now = arrTasks.get(index);
            boolean crntState = now.isCompleted();

            if (answer.equals("y")) {
                now.setCompleted(!crntState);
                LocalDateTime localDate = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String updateTime = localDate.format(formatter);
                now.setUpdatedAt(updateTime);
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

    public void readAllTask(ArrayList<todo> arrTasks){
        for(int i=0;i<arrTasks.size();i++){
            todo task = arrTasks.get(i);
            System.out.println(task.toString());
        }

    }

    public void deleteTask(ArrayList<todo> arrTasks){
        int index = readTask(arrTasks);
        arrTasks.remove(index);
        System.out.println("delete success");
    }
}

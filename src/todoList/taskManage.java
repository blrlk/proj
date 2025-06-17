package todoList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class taskManage {
    public ArrayList<todo> addTask(){
        Scanner input = new Scanner(System.in);
        ArrayList<todo> arrTasks  = new ArrayList<todo>();
        todo task = new todo();

        while(true){
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

    public void readTask(ArrayList<todo> arr){
        for(int i=0;i<arr.size();i++){
            todo task = arr.get(i);
            String id = task.getId();
            String title = task.getTitle();
            boolean completed = task.isCompleted();
            String createdTime = task.getCreatedAt();
            String updatedTime = task.getUpdatedAt();

            System.out.println("id: "+id + "\ntitle: "+title + "\n완료 여부: "+completed + "\n생성 시간: "+createdTime + "업데이트 시간: "+updatedTime);
        }
    }
}

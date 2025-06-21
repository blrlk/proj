package v2;

import domain.Todo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

//저장소
public class TodoRepository {
    Scanner input = new Scanner(System.in);
    ArrayList<Todo> list = new ArrayList<Todo>();
    Optional<Todo> optionalTodo = Optional.empty();
    static int id=1;

    public ArrayList<Todo> save(){
        while(true){
            System.out.print("title을 입력하세요(종료 원할 시 엔터) ");
            String title = input.nextLine();
            if(title.isEmpty()){break;}
            Todo todo = new Todo(id, title, false, LocalDateTime.now(), LocalDateTime.now());
            list.add(todo);

            id++;
        }

        return list;
    }

    public Optional<Todo> findById(int index){
        if(index>=0 && index<list.size()){
            return Optional.of(list.get(index));
        } else{
            return Optional.empty();
        }
    }

    public void findAll(){
        for(int i=0;i<list.size();i++){
            Todo todo = list.get(i);
            System.out.println(todo.toString());
        }
    }

    public void delete(TodoService todoService){
        int index = todoService.getIndex(list);
        optionalTodo = findById(index);
        if(optionalTodo.isPresent()){
            int deletedId = list.get(index).getId();
            list.remove(index);
            System.out.println(deletedId + " 삭제 완료");
        } else{
            System.out.println("해당 id는 존재하지 않습니다.");
        }
    }

}

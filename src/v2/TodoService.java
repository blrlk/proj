package v2;

import domain.Todo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

//내부 비즈니스 로직
public class TodoService {
    Scanner input = new Scanner(System.in);
    Optional<Todo> optionalTodo = Optional.empty();;
    int index = 0;

    public int getIndex(ArrayList<Todo> list){
        System.out.print("Enter id ");
        int id = Integer.parseInt(input.nextLine());
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==id){
                index = i;
                return index;
            }
        }

        return -1;
    }

    public void updateState(ArrayList<Todo> list, TodoRepository todoRepository) {
        index = getIndex(list);
        optionalTodo = todoRepository.findById(index);
        if(optionalTodo.isPresent()){
            Todo todo = list.get(index);
            boolean state = todo.isCompleted();
            todo.setCompleted(!state);
            todo.setUpdatedAt(LocalDateTime.now());
            System.out.println("상태 업데이트 완료");
        } else{
            System.out.println("해당 id는 존재하지 않습니다.");
        }

    }

    public void checkRead(ArrayList<Todo> list, TodoRepository todoRepositody) {
        index = getIndex(list);
        optionalTodo = todoRepositody.findById(index);
        if (optionalTodo.isPresent()) {
            System.out.println(optionalTodo.get());
        } else {
            System.out.println("해당 id는 존재하지 않습니다.");
        }
    }
}

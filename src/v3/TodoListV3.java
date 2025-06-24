package v3;

import v3.dto.Todo;
import v3.service.TodoServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

//TodoList - > TodoService -> TodoRepository -> TodoService -> TodoList
public class TodoListV3 {

    public long chooseTodo(TodoServiceImpl todoService) {
        Scanner input = new Scanner(System.in);

        System.out.println("할 일을 선택하세요 ");
        ArrayList<Todo> temp = todoService.getAllTodo();
        for(int i=0;i<temp.size();i++){
            System.out.print(temp.get(i).getId());
            if (i < temp.size() - 1) {
                System.out.print(" / ");
            }
        }
        System.out.println();
        long checkId = input.nextLong();
        input.nextLine();

        return checkId;
    }


    public static void main(String[] args){
        TodoListV3 todoList = new TodoListV3();
        Scanner input = new Scanner(System.in);
        TodoServiceImpl todoService = new TodoServiceImpl();
        Todo todo;

        while(true){
            System.out.println("\n===== select function =====");
            System.out.println("1. Add task / 2. Read task / 3. Change State / 4. Read all task / 5. Delete task / 6. exit");

            int choice = input.nextInt();
            input.nextLine();
            if(choice == 6){ break; }

            long checkId;

            switch(choice){
                case 1:
                    System.out.println("할 일을 추가하겠습니다. 작성 완료 시 enter 입력");
                    while(true){
                        System.out.print("제목을 입력해주세요. ");
                        String title = input.nextLine();
                        if(title.isEmpty()){ break; }
                        todo = new Todo(title, false, LocalDateTime.now(), LocalDateTime.now());
                        todoService.addTodo(todo);
                    }

                    System.out.println("\nSUCCESS ADD TASK");
                    break;
                case 2:
                    checkId = todoList.chooseTodo(todoService);
                    todoService.readTodo(checkId);
                    break;
                case 3:
                    checkId = todoList.chooseTodo(todoService);
                    System.out.print(checkId + "의 상태를 변경하시겠습니까?(y/n) ");
                    if(input.nextLine().equals("y")){
                        boolean result = todoService.changeTodo(checkId);
                        if(result){
                            System.out.println("\nSUCCESS CHANGE STATE");
                        }
                    } else{
                        System.out.println(checkId + "의 상태 변경이 취소되었습니다.");
                    }

                    break;
                case 4:
                    System.out.println("== TodoList 목록 출력 ==");
                    ArrayList<Todo> arrayList = todoService.getAllTodo();
                    for(int i=0;i<arrayList.size();i++){
                        todo = arrayList.get(i);
                        System.out.println(todo.toString());
                    }
                    break;
                case 5:
                    checkId = todoList.chooseTodo(todoService);
                    System.out.print(checkId + "를 삭제하시겠습니까?(y/n) ");
                    if(input.nextLine().equals("y")){
                        boolean result = todoService.deleteTodo(checkId);;
                        if(result){
                            System.out.println("\nSUCCESS DELETE");
                        }
                    } else{
                        System.out.println(checkId + "의 삭제가 취소되었습니다.");
                    }

                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}

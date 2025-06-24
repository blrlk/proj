package v2;

import domain.Todo;

import java.util.ArrayList;
import java.util.Scanner;

//입출력
public class TodoListV2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TodoRepositoryV2 todoRepository = new TodoRepositoryV2();
        TodoServiceV2 todoService = new TodoServiceV2();
        ArrayList<Todo> list = null;

        while(true){
            System.out.println("\n===== select function =====");
            System.out.println("1. Add task / 2. Read task / 3. check / 4. Read all task / 5. Delete task / 6. exit");

            String choice = input.nextLine();
            if(choice.equals("6")){break;}

            switch(choice){
                case "1":
                    list = todoRepository.save();
                    break;
                case "2":
                    try{
                        todoService.checkRead(list, todoRepository);
                    } catch(Exception e){System.out.println(e);}
                    break;
                case "3":
                    try{
                        todoService.updateState(list, todoRepository);
                    } catch(Exception e){System.out.println(e);}
                    break;
                case "4":
                    try{
                        todoRepository.findAll();
                    } catch(Exception e){System.out.println(e);}
                    break;
                case "5":
                    try{
                        todoRepository.delete(todoService);
                    } catch(Exception e){System.out.println(e);}
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

    }
}

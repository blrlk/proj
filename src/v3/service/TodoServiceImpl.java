package v3.service;

import v3.dto.Todo;
import v3.repository.TodoMemoryRepository;

import java.util.ArrayList;
import java.util.Optional;

public class TodoServiceImpl implements TodoService {
    TodoMemoryRepository todoMemoryRepository = new TodoMemoryRepository();

    @Override
    public void addTodo(Todo todo) {
        todoMemoryRepository.save(todo);
    }

    @Override
    public void readTodo(long checkId) {
        Optional<Todo> optionaltodo = todoMemoryRepository.findById(checkId);
        if(optionaltodo.isPresent()){
            System.out.println(optionaltodo.toString());
        } else{
            System.out.println("해당 id는 존재하지 않습니다.");
        }
    }

    @Override
    public boolean changeTodo(long checkId) {
        Optional<Todo> optionaltodo = todoMemoryRepository.findById(checkId);
        if(optionaltodo.isPresent()){
            Todo todo = optionaltodo.get();
            todo.changeStatus(todo.isCompleted());
            return true;
        } else{
            System.out.println("해당 id는 존재하지 않습니다.");
            return false;
        }
    }

    @Override
    public ArrayList<Todo> getAllTodo() {
        return todoMemoryRepository.findAll();
    }

    @Override
    public boolean deleteTodo(long checkId) {
        Optional<Todo> optionaltodo = todoMemoryRepository.findById(checkId);
        if(optionaltodo.isPresent()){
            todoMemoryRepository.delete(optionaltodo);
            return true;
        } else{
            System.out.println("해당 id는 존재하지 않습니다.");
            return false;
        }
    }
}

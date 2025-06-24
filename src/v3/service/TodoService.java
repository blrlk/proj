package v3.service;

import v3.dto.Todo;

import java.util.ArrayList;

public interface TodoService {
    public void addTodo(Todo todo);
    public void readTodo(long checkId);
    public boolean changeTodo(long checkId);
    public ArrayList<Todo> getAllTodo();
    public boolean deleteTodo(long checkId);
}

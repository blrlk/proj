package v3.repository;

import v3.dto.Todo;

import java.util.ArrayList;
import java.util.Optional;

public interface TodoRepository {
    public ArrayList<Todo> save(Todo todo);
    public Optional<Todo> findById(long id);
    public ArrayList<Todo> findAll();
    public void delete(Optional<Todo> optionaltodo);
}

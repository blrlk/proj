package v3.repository;

import v3.dto.Todo;

import java.util.ArrayList;
import java.util.Optional;

public class TodoMemoryRepository implements TodoRepository {
    private static ArrayList<Todo> arrayList = new ArrayList<>();

    @Override
    public ArrayList<Todo> save(Todo todo) {
        arrayList.add(todo);

        return arrayList;
    }

    @Override
    public Optional<Todo> findById(long id) {
        for(int i=0;i<arrayList.size();i++){
            Todo todo = arrayList.get(i);

            if(todo.getId() == id){
                return Optional.of(todo);
            }
        }
        return Optional.empty();
    }

    @Override
    public ArrayList<Todo> findAll() {
        return arrayList;
    }

    @Override
    public void delete(Optional<Todo> optionaltodo) {
        arrayList.remove(optionaltodo.get());
    }
}

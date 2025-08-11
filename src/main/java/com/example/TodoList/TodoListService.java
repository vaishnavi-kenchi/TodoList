package com.example.TodoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {

    private final TodoListRepository TodoListRepo;

    @Autowired
    public TodoListService(TodoListRepository TodoListRepo) {
        this.TodoListRepo = TodoListRepo;
    }

    public TodoListEntity createTodo(TodoListEntity todo) {
        return TodoListRepo.save(todo);
    }

    public List<TodoListEntity> getAllTodos() {
        return TodoListRepo.findAll();
    }

   

    public TodoListEntity updateTodo(Long id, TodoListEntity updatedTodo) {
    	 TodoListEntity existingTodo = TodoListRepo.findById(id)
    		        .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));

    		    existingTodo.setTitle(updatedTodo.getTitle());
        return TodoListRepo.save(existingTodo);
    }

    public void deleteTodo(Long id) {
    	TodoListEntity todo = TodoListRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
        TodoListRepo.delete(todo);
    }
}

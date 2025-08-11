package com.example.TodoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Todos")
public class TodoListController {
	@Autowired
    private final TodoListService todoListService;

   
    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    
    @PostMapping
    public TodoListEntity createTodo(@RequestBody TodoListEntity todo) {
        return todoListService.createTodo(todo);
    }

    
    @GetMapping("/all")
    public List<TodoListEntity> getAllTodos() {
        return todoListService.getAllTodos();
    }

    
    @PutMapping("/update")
    public TodoListEntity updateTodo(@RequestParam Long id, @ModelAttribute TodoListEntity updatedTodo) {
        return todoListService.updateTodo(id, updatedTodo);
    }

    
    @DeleteMapping("/delete")
    public void deleteTodo(@RequestParam Long id) {
        todoListService.deleteTodo(id);
    }
}




package com.example.backendtodo.controller;

import com.example.backendtodo.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/todo")
public class TodoController {
    static List<Todo> todos = new ArrayList<>();

    static {
       todos.add(new Todo().setId(1).setDescription("Công việc của tôi 1"));
        todos.add(new Todo().setId(2).setDescription("Công việc của tôi 2"));
        todos.add(new Todo().setId(3).setDescription("Công việc của tôi 3"));
        todos.add(new Todo().setId(4).setDescription("Công việc của tôi 4"));
        todos.add(new Todo().setId(5).setDescription("Công việc của tôi 5"));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Todo todo){
        if(todos.isEmpty()){
            todo.setId(1);
        }
        else {
            todo.setId(todos.get(todos.size()-1).getId()+1);
        }
        todos.add(todo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

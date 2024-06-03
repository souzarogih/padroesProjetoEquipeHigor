package com.higorsouza.todolistobserver.controller;

import com.higorsouza.todolistobserver.model.ToDoItem;
import com.higorsouza.todolistobserver.model.ToDoList;
import com.higorsouza.todolistobserver.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping("/list")
    public ToDoList createToDoList(@RequestBody String name) {
        return toDoService.createToDoList();
    }

    @PostMapping("/list/{listId}/item")
    public ToDoItem addItem(@PathVariable Long listId, @RequestBody ToDoItem toDoItem) {
        return toDoService.addItem(listId, toDoItem);
    }

    @GetMapping("/list/{listId}")
    public Optional<ToDoList> getToDoList(@PathVariable Long listId) {
        return toDoService.getToDoList(listId);
    }

    @GetMapping("/item/{itemId}")
    public Optional<ToDoItem> getToDoItem(@PathVariable Long itemId) {
        return toDoService.getToDoItem(itemId);
    }

    @DeleteMapping("/list/{listId}/item/{itemId}")
    public void deleteToDoItem(@PathVariable Long itemId, @PathVariable Long listId) {
        toDoService.deleteToDoItem(listId, itemId);
    }

    @PatchMapping("/item/{itemId}")
    public ToDoItem toDoItemMarkAsDone(@PathVariable Long itemId) {
        System.out.println("entrou na controller toDoItemMarkAsDone");
        return toDoService.updateToDoItem(itemId);
    }
}

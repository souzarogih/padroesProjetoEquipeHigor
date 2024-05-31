package com.higorsouza.todolistobserver.observer;

import com.higorsouza.todolistobserver.model.ToDoItem;
import com.higorsouza.todolistobserver.model.ToDoList;

public class ConsoleObserver implements Observer {
    private ToDoList toDoList;

    public ConsoleObserver(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    @Override
    public void update() {
        System.out.println("To-Do List updated:");
        for (ToDoItem item : toDoList.getItems()) {
            System.out.println(item);
        }
    }
}

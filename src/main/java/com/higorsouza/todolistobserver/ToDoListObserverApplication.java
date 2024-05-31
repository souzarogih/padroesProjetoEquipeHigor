package com.higorsouza.todolistobserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoListObserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoListObserverApplication.class, args);

//        ToDoList toDoList = new ToDoList();
//        ConsoleObserver consoleObserver = new ConsoleObserver(toDoList);
//
//        toDoList.addObserver(consoleObserver);
//
//        ToDoItem item1 = new ToDoItem("Buy milk");
//        ToDoItem item2 = new ToDoItem("Clean the house");
//
//        toDoList.addItem(item1);
//        toDoList.addItem(item2);
//
//        item1.markAsDone();
//        toDoList.notifyObservers();
    }

}

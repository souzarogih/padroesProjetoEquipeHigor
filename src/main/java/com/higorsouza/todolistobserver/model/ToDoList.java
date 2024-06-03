package com.higorsouza.todolistobserver.model;

import com.higorsouza.todolistobserver.observer.Observer;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "to_do_list")
public class ToDoList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ToDoItem> items;

    @Transient
    private List<Observer> observers = new ArrayList<>();
//    private List<Observer> observers;

    public ToDoList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ToDoItem> getItems() {
        return items;
    }

    public void setItems(List<ToDoItem> items) {
        this.items = items;
    }

    public void addItem(ToDoItem item) {
        items.add(item);
        notifyObservers();
    }

    public void removeItem(ToDoItem item) {
        items.remove(item);
        notifyObservers();
    }

    public void listItem() {
        getItems();
        notifyObservers();
    }


    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }


}

package com.higorsouza.todolistobserver.model;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "to_do_item")
public class ToDoItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private boolean isDone;

    public ToDoItem() {
    }

    public ToDoItem(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return (isDone ? "[X] " : "[ ] ") + description;
    }

}

package com.higorsouza.todolistobserver.service;

import com.higorsouza.todolistobserver.observer.ConsoleObserver;
import com.higorsouza.todolistobserver.model.ToDoItem;
import com.higorsouza.todolistobserver.model.ToDoList;
import com.higorsouza.todolistobserver.repository.ToDoItemRepository;
import com.higorsouza.todolistobserver.repository.ToDoListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ToDoService {

    private static final Logger logger = LoggerFactory.getLogger(ToDoService.class);

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    public ToDoList createToDoList() {
        logger.info("Criando uma nova lista");
        ToDoList toDoList = new ToDoList();
        return toDoListRepository.save(toDoList);
    }

    public ToDoItem addItem(Long listId, ToDoItem item) {
        logger.info("Adicionando o item: {} na lista: {}", item, listId);

        ToDoList toDoList = toDoListRepository.findById(listId).orElseThrow(() -> new RuntimeException("List not found"));
        ConsoleObserver consoleObserver = new ConsoleObserver(toDoList);
        toDoList.addObserver(consoleObserver);
        toDoList.addItem(item);
        ToDoList itemSaved = toDoListRepository.save(toDoList);
        System.out.println("::: " + itemSaved.getItems());
        System.out.println("::::" + item);
        return item;
    }

    public Optional<ToDoList> getToDoList(Long listId) {
        logger.info("Obtendo a lista: {}", listId);
        ToDoList toDoList = toDoListRepository.findById(listId).orElseThrow(() -> new RuntimeException("List not found"));
        ConsoleObserver consoleObserver = new ConsoleObserver(toDoList);
        toDoList.addObserver(consoleObserver);
        toDoList.listItem();
        return toDoListRepository.findById(listId);
    }

    public Optional<ToDoItem> getToDoItem(Long itemId) {
        logger.info("Obtendo o item: {}", itemId);
        return toDoItemRepository.findById(itemId);
    }

    public ToDoItem updateToDoItem(Long itemId) {
        logger.info("Atualizando dados do item: {}", itemId);

        Optional<ToDoItem> item = toDoItemRepository.findById(itemId);
        if (item.isPresent()){
            ToDoItem toDoItem = new ToDoItem();
            toDoItem.setId(item.get().getId());
            toDoItem.markAsDone();
            toDoItem.setDescription(item.get().getDescription());
            toDoItemRepository.save(toDoItem);
            return toDoItem;
        } else {
            logger.info("Item not found with id: {}", itemId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found with id: " + itemId);
        }
    }

    public void deleteToDoItem(Long listId, Long itemId) {
        logger.info("Removendo item: {} ", itemId);
//        Optional<ToDoItem> item = toDoItemRepository.findById(itemId);
//        if (item.isPresent()){
//            toDoItemRepository.deleteById(itemId);

            ToDoList toDoList = toDoListRepository.findById(listId).orElseThrow(() -> new RuntimeException("List not found"));
            ToDoItem toDoItem = toDoItemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));
            ConsoleObserver consoleObserver = new ConsoleObserver(toDoList);
            toDoList.addObserver(consoleObserver);
            toDoList.removeItem(toDoItem);
            toDoItemRepository.delete(toDoItem);
            toDoListRepository.save(toDoList);

//        }

    }
}

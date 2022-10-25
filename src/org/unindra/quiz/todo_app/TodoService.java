package org.unindra.quiz.todo_app;

import java.util.*;
import java.util.stream.Collectors;

public class TodoService {

    private final List<Todo> todos;

    public TodoService() {
        this.todos = new ArrayList<>(Arrays.asList(
                new Todo("Makan", true),
                new Todo("Tidur", false)
        ));
    }

    public void createNew(Todo todo) {
        todos.add(todo);
        System.out.println("Successfully Add Todo");
    }

    public List<Todo> listTodo() {
        if (!todos.isEmpty()) {
            return todos.stream().sorted(Comparator.comparing(Todo::getTodo)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public boolean updateStatus(String todo) {
        Todo currentTodo = getTodoByName(todo);
        if (currentTodo == null) return false;
        currentTodo.setDone(!currentTodo.getDone());
        System.out.println("Successfully update todo");
        return true;
    }

    public boolean deleteTodo(String todo) {
        Todo currentTodo = getTodoByName(todo);
        if (currentTodo == null) return false;
        todos.remove(currentTodo);
        System.out.println("Successfully delete todo");
        return true;
    }

    private Todo getTodoByName(String todo) {
        for (Todo currentTodo : todos) {
            if (currentTodo.getTodo().equalsIgnoreCase(todo)) {
                return currentTodo;
            }
        }

        return null;
    }

}

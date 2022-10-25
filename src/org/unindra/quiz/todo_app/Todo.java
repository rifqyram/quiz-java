package org.unindra.quiz.todo_app;

public class Todo {

    private String todo;
    private Boolean isDone;

    public Todo(String todo, Boolean isDone) {
        this.todo = todo;
        this.isDone = isDone;
    }

    public String getTodo() {
        return todo;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todo='" + todo + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}

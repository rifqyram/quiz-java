package org.unindra.quiz.todo_app;

import java.util.List;
import java.util.Scanner;

public class TodoApp {

    public static void main(String[] args) {
        TodoService todoService = new TodoService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Input Todo");
            System.out.println("2. Lihat Todo");
            System.out.println("3. Ubah Status Todo");
            System.out.println("4. Hapus Todo");
            System.out.print("Pilih: ");

            switch (scanner.nextLine()) {
                case "1":
                    System.out.print("Masukkan todo: ");
                    String todo = scanner.nextLine();
                    todoService.createNew(new Todo(todo, false));
                    break;
                case "2":
                    List<Todo> todos = todoService.listTodo();
                    todos.forEach(System.out::println);
                    break;
                case "3":
                    System.out.print("Masukkan todo: ");
                    String updateTodo = scanner.nextLine();
                    boolean updated = todoService.updateStatus(updateTodo);
                    if (!updated) System.out.println("Failed Update Todo");
                    break;
                case "4":
                    System.out.print("Masukkan todo: ");
                    String deleteTodo = scanner.nextLine();
                    boolean deleted = todoService.deleteTodo(deleteTodo);
                    if (!deleted) System.out.println("Failed Delete Todo");
                    break;
                case "X":
                case "x":
                    System.exit(0);
                    break;
            }
        }
    }

}

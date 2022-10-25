package org.unindra.quiz.hotel_app;

import org.unindra.quiz.Utils;

public class Menu {

    private final TransactionService transactionService;

    public Menu(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void showMenu() {
        System.out.println("===== Welcome to Hotel Panoramic =====");

        while (true) {
            showListRoom();
            String option = Utils.inputUtils("Choose room you want to book [Category/Number]");
            Room room = transactionService.getRoomByIdOrName(option);

            if (room != null) {
                createTransaction(room);
                return;
            }

            System.out.println("Room not found");
        }

    }

    private void createTransaction(Room room) {
        String name = Utils.inputUtils("Input your name");
        String mobilePhone = Utils.inputUtils("Input your phone number");
        Customer customer = new Customer(name, mobilePhone);

        try {
            Integer stay = Integer.parseInt(Utils.inputUtils("duration of stay"));
            transactionService.createTransaction(customer, room, stay);
        } catch (Exception e) {
            System.out.println("Input number only!");
            showMenu();
        }
    }

    private void showListRoom() {
        System.out.println("List Room");
        System.out.printf("%-5s %-20s %-10s\n", "No.", "Room Category", "Room Price");
        System.out.println(Utils.repeat("-", 40));
        for (Room room : transactionService.getListRoom()) {
            System.out.printf("%-5s %-20s %-10s\n", String.format("%s.", room.getId()), room.getRoomCategory(), Utils.convertRupiah(room.getPrice()));
        }
    }

}

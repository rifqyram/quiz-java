package org.unindra.quiz.hotel_app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransactionService {

    private final List<Room> rooms;

    public TransactionService() {
        this.rooms = initRoom();
    }

    private List<Room> initRoom() {
        Room standard = new Room("1", "Standard", 400000);
        Room superior = new Room("2", "Superior", 500000);
        Room deluxe = new Room("3", "Deluxe", 650000);
        Room suite = new Room("4", "Suite", 750000);
        return new ArrayList<>(Arrays.asList(standard, superior, deluxe, suite));
    }

    public void createTransaction(Customer customer, Room room, Integer stay) {
        Transaction transaction = new Transaction(customer, room, stay, stay * room.getPrice());
        transaction.getTransactionDetail();
    }

    public List<Room> getListRoom() {
        return rooms;
    }

    public Room getRoomByIdOrName(String keyword) {
        for (Room room : rooms) {
            if (room.getRoomCategory().equalsIgnoreCase(keyword) || room.getId().equalsIgnoreCase(keyword)) {
                return room;
            }
        }

        return null;
    }
}

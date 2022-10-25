package org.unindra.quiz.hotel_app;

import org.unindra.quiz.Utils;

public class Transaction {

    private final Customer customer;
    private final Room room;
    private final Integer stay;
    private final Integer totalBill;

    public Transaction(Customer customer, Room room, Integer stay, Integer totalBill) {
        this.customer = customer;
        this.room = room;
        this.stay = stay;
        this.totalBill = totalBill;
    }

    public void getTransactionDetail() {
        System.out.println(Utils.repeat("-", 50));
        System.out.println("\t Detail Transaction");

        System.out.printf("%-20s %-20s %-30s %-30s\n", "Customer Name", "Room Category", "Stay", "Total Bills");
        System.out.println(Utils.repeat("-", 100));
        System.out.printf("%-20s %-20s %-30s %-30s\n", customer.getName(), room.getRoomCategory(), String.format("%d Night", stay), Utils.convertRupiah(totalBill));
    }

}

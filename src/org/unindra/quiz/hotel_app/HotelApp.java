package org.unindra.quiz.hotel_app;

public class HotelApp {

    public static void main(String[] args) {
        TransactionService transactionService = new TransactionService();
        Menu menu = new Menu(transactionService);
        menu.showMenu();
    }

}

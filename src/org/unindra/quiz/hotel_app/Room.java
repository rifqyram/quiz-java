package org.unindra.quiz.hotel_app;

public class Room {
    private String id;
    private String roomCategory;
    private Integer price;

    public Room(String id, String roomCategory, Integer price) {
        this.id = id;
        this.roomCategory = roomCategory;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

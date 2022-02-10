package com.engeto.lesson2;

import java.math.BigDecimal;

public class Room {
    private int id;
    private int bedsInRoom;
    private boolean isBalcony;
    private boolean isSeeView;
    private BigDecimal price;

    public Room(int id, int bedsInRoom, boolean isBalcony, boolean isSeeView, BigDecimal price) {
        this.id = id;
        setBedsInRoom(bedsInRoom);
        this.isBalcony = isBalcony;
        this.isSeeView = isSeeView;
        this.price = price;
    }

    public String getDescription() {
        return "ROOM number: " + id + " | size: " + bedsInRoom + " bed(s) | "
                + ((isBalcony) ? "with balcony" : "without balcony") + " | " + ((isSeeView) ? "see view" : "no see view") + " | price: " + price + "Kč";
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", bedsInRoom=" + bedsInRoom +
                ", isBalcony=" + isBalcony +
                ", isSeeView=" + isSeeView +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBedsInRoom() {
        return bedsInRoom;
    }

    public void setBedsInRoom(int bedsInRoom) {

        if(bedsInRoom > 0 && bedsInRoom < 9)
            this.bedsInRoom = bedsInRoom;
        else
            this.bedsInRoom = 1;
    }

    public boolean isBalcony() {
        return isBalcony;
    }

    public void setBalcony(boolean balcony) {
        isBalcony = balcony;
    }

    public boolean isSeeView() {
        return isSeeView;
    }

    public void setSeeView(boolean seeView) {
        isSeeView = seeView;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

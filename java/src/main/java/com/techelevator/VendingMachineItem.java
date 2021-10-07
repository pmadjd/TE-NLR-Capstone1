package com.techelevator;

public abstract class VendingMachineItem {

    private String name;
    private double price;
    private String sound;
    private int quantity;
    private String slotID;

    public VendingMachineItem(String name, double price, String sound, int quantity, String slotID) {
        this.name = name;
        this.price = price;
        this.sound = sound;
        this.quantity = 5;
        this.slotID = slotID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }
}

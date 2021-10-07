package com.techelevator;

public abstract class VendingMachineItem {

    private String name;
    private double price;
    private String sound;

    public VendingMachineItem(String name, double price, String sound) {
        this.name = name;
        this.price = price;
        this.sound = sound;
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
}

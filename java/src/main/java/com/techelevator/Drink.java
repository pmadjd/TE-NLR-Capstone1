package com.techelevator;

public class Drink extends VendingMachineItem{

    public Drink(String name, double price, String sound, int quantity, String slotID) {
        super(name, price, "Glug Glug, Yum!", quantity, slotID);
    }
}

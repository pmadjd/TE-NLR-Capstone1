package com.techelevator;

public class Candy extends VendingMachineItem{

    public Candy(String name, double price, String sound, int quantity, String slotID) {
        super(name, price, "Munch Munch, Yum!", quantity, slotID);
    }
}


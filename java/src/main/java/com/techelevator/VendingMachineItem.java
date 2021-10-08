package com.techelevator;

import java.math.BigDecimal;

public abstract class VendingMachineItem {

    private String name;
    private BigDecimal price;

    public VendingMachineItem(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

}

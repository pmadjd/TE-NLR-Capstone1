package com.techelevator;

import javax.sound.midi.SysexMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

    private Map<String, VendingMachineItem> inventory = new LinkedHashMap<String, VendingMachineItem>();

    public VendingMachine(){
        inventoryReader();
    }

    public void inventoryReader() {

        try (Scanner inputScanner = new Scanner(new File("vendingmachine.csv"))) {

            while (inputScanner.hasNextLine()) {
                String line = inputScanner.nextLine();

                try {
                    String[] array = line.split("\\|");
                    String slot = array[0];
                    String name = array[1];
                    BigDecimal price = new BigDecimal(array[2]);
                    String type = array[3];

                    VendingMachineItem vendingMachineItem = null;
                    if(type.equals("Chip")){
                        vendingMachineItem = new Chips(name, price);
                    }
                    if(type.equals("Candy")){
                        vendingMachineItem = new Candy(name, price);
                    }
                    if(type.equals("Gum")){
                        vendingMachineItem = new Gum(name, price);
                    }
                    if(type.equals("Drink")){
                        vendingMachineItem = new Drink(name, price);
                    }

                    inventory.put(slot,vendingMachineItem);

                } catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    BigDecimal balance = new BigDecimal(0.00);

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void feedMoney(int addedMoney){
        if (addedMoney == 1){
            BigDecimal oneDollar = new BigDecimal(1.00);
            balance = balance.add(oneDollar);
        }
        else if (addedMoney == 2){
            BigDecimal twoDollars = new BigDecimal(2.00);
            balance = balance.add(twoDollars);
        }
        else if (addedMoney == 5){
            BigDecimal fiveDollars = new BigDecimal(5.00);
            balance = balance.add(fiveDollars);
        }
        else if (addedMoney == 10){
            BigDecimal tenDollars = new BigDecimal(10.00);
            balance = balance.add(tenDollars);
        }
        else {
            System.out.println(addedMoney + " is not a valid bill amount.");
        }

        System.out.println("Current balance is $" + balance);
    }

    public Collection<String> getSlots(){return inventory.keySet();}

    public VendingMachineItem getItem(String slot) {
        return inventory.get(slot);
    }


}

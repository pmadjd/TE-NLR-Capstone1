package com.techelevator;

import javax.sound.midi.SysexMessage;
import java.math.BigDecimal;

public class VendingMachine {

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
}

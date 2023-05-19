package com.solveiga;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Savings implements Illustration{
   private double balance = 0.00;
   private double deposit;
   private int years;
   private double interestRate;
   private double interest;
   private Person person;

    public Savings(double deposit, int years, Person person) {
        this.balance = deposit;
        this.years = years;
        this.person = person;
        this.interestRate = findInterestRate(years); //can it be here? new BigDecimal(findInterestRate(years)).setScale(2, RoundingMode.HALF_EVEN);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double deposit){
        this.balance += deposit;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
        } else {
            System.out.println("You don't have sufficient funds");
        }
    }

    private double findInterestRate(int years) {
        switch (years) {
            case 1:
                return 1.00;
               // break;
            case 2:
                return 1.50;
                //break;
            case 3:
                return 2.00;
               // break;
            case 4:
                return 2.50;
              //  break;
            default:
                return 2.85;
        }
    }

    private double calculateInterestForFixedTerm() {
        return interest = (balance * interestRate * years) / 100;
    }

    @Override
    public String generateIllustration() {
        BigDecimal decimalInterestRate = new BigDecimal(interestRate).setScale(2);
        BigDecimal decimalInterestAmount = new BigDecimal(calculateInterestForFixedTerm()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal decimalBalance = new BigDecimal(balance).setScale(2);
        return person.printPersonalDetails()
                +"\n\tSavings Illustartion For Fixed Term"
                +"\nDeposit amount: £" + decimalBalance
                +"\nFixed term: " + years
                +"\nInterest Rate: " + decimalInterestRate + "%"
                +"\nInterest for the perdiod: £" + decimalInterestAmount;
    }
}

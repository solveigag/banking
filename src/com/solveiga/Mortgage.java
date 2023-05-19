package com.solveiga;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Mortgage implements Illustration {

    int propValue;
    int term;
    int deposit;
    int mortgageAmount;
    double ltv;
    double interestRate;
    private Person person;
    double monthlyPayment;

    public Mortgage(Person person, int propertyValue, int term, int deposit) {
        this.person = person;
        this.propValue = propertyValue;
        this.term = term;
        this.deposit = deposit;
        this.ltv = findLTV();
        this.interestRate = findInterestRate();
        this.monthlyPayment = calculateMonthlyPayment();  //can a constructor call a method, so it kicks off immediately?
    }

    private double findLTV() {
        mortgageAmount = propValue - deposit;
        return ((double) mortgageAmount/propValue) * 100;
    }

    private double findInterestRate() {
         if (ltv < 50) return 2.00;
         if (ltv > 75) return 5.00;
         else return 3.74;
    }

    private double calculateMonthlyPayment() {
        int period = term * 12;
        double rate = (interestRate/100)/12;
        return (double) Math.round((mortgageAmount * rate) / (1 - Math.pow(1 + rate, -period)) * 100) / 100;
//
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }
    @Override
    public String generateIllustration() {
        BigDecimal LTV = new BigDecimal(ltv).setScale(2, RoundingMode.HALF_DOWN);

        return person.printPersonalDetails() + "\n\tMortgage Illustration: "
                +"\nProperty Value: £" + propValue
                +"\nDeposit: £" + deposit
                +"\nMortgage term: " + term
                +"\nInterest Rate: " + interestRate + "%"
                +"\nMortgage amount: £" + mortgageAmount
                +"\nLTV: " + LTV + "%"
                +"\nMonthly payment: £" + monthlyPayment;

    }



}

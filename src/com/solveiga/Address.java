package com.solveiga;

public class Address {

    private String street;
    private String city;
    private String postCode;


    public Address(String street, String city, String postCode) {
        this.street = street;
        this.city = city;
        this.postCode = postCode;
    }

    public String printAddress() {
        return "Street: " + street
                +"\nCity: " + city
                +"\nPost Code: " + postCode;
    }
}

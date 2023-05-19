package com.solveiga;

public class Person {

    private String firstName;
    private String lastName;
    private final String DOB;
    private Address address;

    public Person(String firstName, String lastName, String DOB){
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String printPersonalDetails() {
        return  "\tPersonal Details: "
                +"\nFirst name: " + firstName
                +"\nLast name: " + lastName
                +"\nDate of Birth: " + DOB
                +"\n\tAddress: "
                +"\n" + address.printAddress();
    }

}


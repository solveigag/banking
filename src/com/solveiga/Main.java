package com.solveiga;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Personal Details
        System.out.println("Welcome to your mortgage application.");
        System.out.println("Please enter your first name.");
        String fname = scanner.nextLine();
        System.out.println("Please enter your last name.");
        String lname = scanner.nextLine();
        System.out.println("Please enter your date of birth.");
        String dob = scanner.nextLine();
        // Address
        System.out.println("Please enter the first line of your address.");
        String street = scanner.nextLine();
        System.out.println("Please enter the city you live in.");
        String city = scanner.nextLine();
        System.out.println("Please enter your post code.");
        String postCode = scanner.nextLine();

        // Create Person & Address

        Person person = new Person(fname, lname, dob);
        Address address = new Address(street, city, postCode);
        person.setAddress(address);

        //Chose to create Savings Or Mortgage and print illiustration
        int choice = getChoice(scanner);

        chooseAccount(person, choice, scanner);

        //Write Illustration into file?

    }

    private static void chooseAccount(Person person, int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                generateMortgage(person);
                break;
            case 2:
                generateSavingsAccount(person);
             break;
            default:
                System.out.println("Enter valid option!");
                choice = getChoice(scanner);
                chooseAccount(person, choice, scanner);
        }
    }

    private static void generateMortgage(Person person) {

        Scanner mortgageGeneration = new Scanner(System.in);

        System.out.println("How much is the property worth?");
        int propertyValue = mortgageGeneration.nextInt();
        System.out.println("How much is your deposit");
        int deposit = mortgageGeneration.nextInt();
        System.out.println("What is the mortgage period?");
        int term = mortgageGeneration.nextInt();

        Mortgage newMortgage = new Mortgage(person, propertyValue, term, deposit);
        System.out.println(newMortgage.generateIllustration());


    }

    private static int getChoice(Scanner scanner) {
        System.out.println("Which account would you like to open? \nEnter 1 for mortgage or 2 for savings");
        return scanner.nextInt();
    }

    private static void generateSavingsAccount(Person person) {
        Scanner savingsGeneration = new Scanner(System.in);

        System.out.println("How much would you like to deposit today?");
        double deposit = savingsGeneration.nextInt();
        System.out.println("How many years is the fixed period for?");
        int years = savingsGeneration.nextInt();

        Savings savings = new Savings(deposit, years, person);
        System.out.println(savings.generateIllustration());
    }
}

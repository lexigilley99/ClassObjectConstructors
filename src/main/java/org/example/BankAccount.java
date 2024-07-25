package org.example;

public class BankAccount {
    private double balance;
    private final String accountHolderName;

    // Constructor
    public BankAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public void printAccountDetails() {
        System.out.println(accountHolderName + "'s account balance: " + balance);
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Lexi Gilley", 500.0);
        account.deposit(100.0);
        account.printAccountDetails();
    }
}



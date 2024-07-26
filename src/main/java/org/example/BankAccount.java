package org.example;

public class BankAccount {
    private static int nextAccountNumber = 1;  // Static variable to generate unique account numbers
    private double balance;
    private final String accountHolderName;
    private final int accountNumber;

    public BankAccount(String accountHolderName, double balance, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountNumber = nextAccountNumber++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Error message.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Error message.");
        }
    }

    public void printAccountDetails() {
        System.out.println("Account Number: " + accountNumber + ", " + accountHolderName + "'s account balance: " + balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void transfer(BankAccount targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            targetAccount.deposit(amount);
            System.out.println("Transferred " + amount + " to account number: " + targetAccount.getAccountNumber());
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}






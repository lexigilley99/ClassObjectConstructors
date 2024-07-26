package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello world! Welcome to the Bank of Matt!");

        while (true) {
            System.out.println("Are you an existing customer? (-1 to exit)");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == -1) {
                break;
            } else if (choice == 1) {
                System.out.print("Enter your account number: ");
                int accountNumber = scanner.nextInt();
                scanner.nextLine();
                BankAccount account = findAccountByNumber(accounts, accountNumber);
                if (account != null) {
                    mainMenu(account, scanner, accounts);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 2) {
                System.out.println("Let's make a new account!");
                System.out.print("What is the name for the account? ");
                String accountHolderName = scanner.nextLine();
                System.out.print("What is the beginning balance for the account? ");
                double balance = scanner.nextDouble();
                scanner.nextLine();

                BankAccount newAccount = new BankAccount(accountHolderName, balance);
                accounts.add(newAccount);
                System.out.println("Account created successfully!");
                newAccount.printAccountDetails();
                mainMenu(newAccount, scanner, accounts);
            }
        }

        scanner.close();
    }

    public static void mainMenu(BankAccount account, Scanner scanner, ArrayList<BankAccount> accounts) {
        System.out.println("Hello " + account.getAccountHolderName() + "!");
        System.out.println("Welcome to the Main Menu, what would you like to do today?");
        while (true) {
            System.out.println("1. To check account balance");
            System.out.println("2. To make a withdrawal");
            System.out.println("3. To make a deposit");
            System.out.println("4. To make a transfer to another account");
            System.out.println("0. To exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                break;
            } else if (choice == 1) {
                account.printAccountDetails();
            } else if (choice == 2) {
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                account.withdraw(amount);
            } else if (choice == 3) {
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                account.deposit(amount);
            } else if (choice == 4) {
                System.out.print("Enter the account number to transfer to: ");
                int targetAccountNumber = scanner.nextInt();
                scanner.nextLine();
                BankAccount targetAccount = findAccountByNumber(accounts, targetAccountNumber);
                if (targetAccount != null) {
                    System.out.print("Enter the amount to transfer: ");
                    double amount = scanner.nextDouble();
                    account.transfer(targetAccount, amount);
                } else {
                    System.out.println("Account doesn't exist.");
                }
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private static BankAccount findAccountByNumber(ArrayList<BankAccount> accounts, int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}



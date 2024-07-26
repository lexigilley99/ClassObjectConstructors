package org.example;

public class BankTransfer {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Larry", 5000.0);
        BankAccount account2 = new BankAccount("Mary", 300.0);

        account1.withdraw(100.0);
        account2.deposit(100.0);

        account1.printAccountDetails();
        account2.printAccountDetails();

        account1.transfer(account2, 200.0);

        account1.printAccountDetails();
        account2.printAccountDetails();
    }
}



package oasis.atm;

import java.util.ArrayList;

public class Account {
    private String userId;
    private String pin;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String userId, String pin, double initialBalance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
            return true;
        }
        return false;
    }

    public boolean transfer(Account toAccount, double amount) {
        if (this.withdraw(amount)) {
            toAccount.deposit(amount);
            transactionHistory.add("Transferred: " + amount + " to " + toAccount.getUserId());
            return true;
        }
        return false;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }
}

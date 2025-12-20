package ht.ueh.first.java;

public class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit: +" + amount + " | Balance = " + balance);
    };

    public synchronized void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("fonds insuffisants | Solde = " + balance);
            return;
        }
        balance -= amount;
        System.out.println("Withdraw: -" + amount + " | Balance = " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

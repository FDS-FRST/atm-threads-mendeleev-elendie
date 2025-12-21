package ht.ueh.first.java;

public class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) throws InvalidAmountException{
        if  (amount <= 0) {
throw  new InvalidAmountException("Invalid deposit amount "+amount);
        }
        balance += amount;
        System.out.println("Deposit successful: +" + amount + " | Balance = " + balance);
    }

    public synchronized void withdraw(double amount) throws  InvalidAmountException, InsufficientFundsException {
        if  (amount <= 0) {
            throw  new InvalidAmountException("Invalid withdraw amount  "+amount);
        }

        if(amount > balance) {
            throw  new InsufficientFundsException("Insufficient Funds| current Balance"+balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful: -" + amount + " | Balance = " + balance);
    }

    public synchronized double getBalance() {
        return balance;
    }
}

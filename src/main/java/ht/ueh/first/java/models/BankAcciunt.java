package ht.ueh.first.java.models;

public class BankAcciunt {
    private int Accountnumber;
    private double balance;

    private BankAcciunt(int Accountnumber, double balance) {
        this.Accountnumber = Accountnumber;
        this.balance = balance;
    }
    public int getAccountnumber() {
        return Accountnumber;
    }

    public double getBalance() {
        return balance;
    }

}

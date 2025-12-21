package ht.ueh.first.java;

public class ATMTask implements Runnable{
    private Action action;
    private BankAccount account;
    private double amount;

    public ATMTask(Action action, BankAccount account, double amount) {
        this.action = action;
        this.account = account;
        this.amount = amount;
    }
@Override
    public void run() {

    String threadName = Thread.currentThread().getName();
    try {


        Thread.sleep(5000);
    } catch (InterruptedException e) {
        System.err.println("[" + threadName + "] Interruption thread:"+e.getMessage());
        return;
    }
    try {
        switch (action) {
            case WITHDRAW:
                account.withdraw(amount);
                System.err.println("[" + threadName + "] Withdrawal successful:-" + amount+" € |New balance:="+account.getBalance());
                break;

            case DEPOSIT:
                account.deposit(amount);
                System.err.println("[" + threadName + "] deposit successful:+" + amount+" € |New balance:="+account.getBalance());
                break;
            case BALANCE:
                System.err.println("[" + threadName + "] current balance:"+account.getBalance()+"€");
                break;

        }
    } catch (InvalidAmountException e) {

        System.err.println("[" + threadName + "] Error("+action+" "+ amount+"€) ->Invalid amount:="+e.getMessage());
    } catch (InsufficientFundsException e) {
        System.err.println("[" + threadName + "] Error("+action+" "+ amount+"€) ->Insufficient funds:="+" "+e.getMessage());
    }

}
}

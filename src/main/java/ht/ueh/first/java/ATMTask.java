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

    public void run()
    {
        try
        {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        switch(action)
        {
            case WITHDRAW: account.withdraw(amount);
            break;

            case DEPOSIT: account.deposit(amount);
            break;

            case BALANCE:
                System.out.println("Solde actuel : " +account.getBalance());
            break;


        }




    }

}

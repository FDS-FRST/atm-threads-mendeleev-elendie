package ht.ueh.first.java;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(123,1000);

        Thread t1 = new Thread(new ATMTask(Action.WITHDRAW,account,700.0));
        Thread t2 = new Thread(new ATMTask(Action.DEPOSIT,account,800.0));
        Thread t3 = new Thread(new ATMTask(Action.WITHDRAW,account,600.0));
        Thread t4 = new  Thread(new ATMTask(Action.BALANCE,account,700.0));
        Thread t5  = new Thread(new ATMTask(Action.DEPOSIT,  account, 100.0));
        Thread t6  = new Thread(new ATMTask(Action.WITHDRAW, account, 200.0));
        Thread t7  = new Thread(new ATMTask(Action.BALANCE,  account, 0.0));
        Thread t8  = new Thread(new ATMTask(Action.WITHDRAW, account, 500.0));
        Thread t9  = new Thread(new ATMTask(Action.DEPOSIT,  account, 150.0));
        Thread t10 = new Thread(new ATMTask(Action.WITHDRAW, account, 200.0));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        /*Theoriquement on attend le solde 300
        et  un seul retrait doit etre
        reussir
        . */

        // J`observe parfois un solde negatif -400

        /*
        Les deux retraits peuvent etre
        reussir a cause , qu`il n`y a pas de
        synchronisation pour permettre a chaque
        thread d`acceder a une donnee specifique.
        Donc les deux threads peuvent acceder
        aux meme donnees
          */

        // ce type de probleme s`appelle race condition ou condition de concurrence


        /*
        Synchronized empeche la race condition , parce qu`il
        bloque une section de code permettant a un seul thread d`y acceder
        a la fois , sans synchronized plusieurs threads peuvent y
        acceder a une ressource partagee et causerait une race condition
        */

        /*
        Si plusieurs threads veulent entrer
        dans la methode , le thread 2 doit attendre que
        le thread 1 se termine avant d`y acceder a cette methode.
         */

    }
}
package ht.ueh.first.java;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(123,1000);

        Thread t1 = new Thread(new ATMTask(Action.WITHDRAW,account,700.0));
        Thread t2 = new Thread(new ATMTask(Action.WITHDRAW,account,700.0));


        t1.start();
        t2.start();



        /*Theoriquement on attend le solde 300
        et  un seul retrait doit etre
        reussir
        .

         */

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


    }
}
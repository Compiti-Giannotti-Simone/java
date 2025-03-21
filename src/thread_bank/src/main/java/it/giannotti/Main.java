package it.giannotti;

public class Main {
    public static void main(String[] args) {
        Thread t_deposit = new Thread(new Depositer());
        Thread t_withdraw = new Thread(new Withdrawer());
        t_deposit.start();
        t_withdraw.start();
    }
}
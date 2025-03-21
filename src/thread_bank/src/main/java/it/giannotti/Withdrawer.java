package it.giannotti;

public class Withdrawer implements Runnable {
    private BankAccount b = BankAccount.getInstance();

    public void run() {
        for (int i = 0; i < 10; i++) {
            int amount = (int) (Math.random() * 40) + 10;
                try {
                    b.withdraw(amount);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
}

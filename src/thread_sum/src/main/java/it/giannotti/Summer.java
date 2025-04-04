package it.giannotti;

public class Summer implements Runnable {

    private ArraySum a;

    private int id,startIndex,threadAmount,indexAmount;

    public Summer(ArraySum a, int threadAmount, int id) {
        this.a = a;
        this.threadAmount = threadAmount;
        this.id = id;
        this.indexAmount = a.getArray().length/threadAmount;
        this.startIndex = indexAmount * id;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < startIndex+indexAmount; i+=2) {
            a.calculate(i,i+1);
        }
    }
}

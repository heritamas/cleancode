package ch12.concurrency.pitfall;


import java.util.concurrent.ConcurrentLinkedQueue;

class  Counter {
    private int counter = 0;

    public void increment() {
        counter++;
    }

    public int getValue() {
        return counter;
    }
}


public class Pitfall {

    public static void main(String[] args) throws InterruptedException {
        final Counter cnt = new Counter();
        final ConcurrentLinkedQueue<Integer> values = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 10; ++i) {
            new Thread(() -> {
                values.add(cnt.getValue());
                cnt.increment();
            }).start();
        }

        Thread.sleep(1000);
        System.out.println(values.toString());
        System.out.println(values.size());
    }

}

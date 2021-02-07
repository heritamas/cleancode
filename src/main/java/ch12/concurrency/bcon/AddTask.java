package ch12.concurrency.bcon;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Task that add 10000 elements to a ConcurrentListDeque
 */
public class AddTask implements Runnable {

    /**
     * List to add the elements
     */
    private final BlockingDeque<String> list;

    /**
     * Constructor of the class
     *
     * @param list List to add the elements
     */
    public AddTask(BlockingDeque<String> list) {
        this.list = list;
    }

    /**
     * Main method of the class. Add 10000 elements to the list using the add()
     * method that adds the element at the end of the list
     */
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            try {
                list.put(name + ": Element " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

package ch12.concurrency.bcon;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Task that delete 10000 elements from a ConcurrentListDeque
 */
public class PollTask implements Runnable {

    /**
     * List to delete the elements
     */
    private final BlockingDeque<String> list;

    /**
     * Constructor of the class
     *
     * @param list List to delete the elements
     */
    public PollTask(BlockingDeque<String> list) {
        this.list = list;
    }

    /**
     * Main method of the task. Deletes 10000 elements from the list using the
     * pollFirst() that deletes the first element of the list and pollLast()
     * that deletes the last element of the list
     */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                String takenFirst = list.takeFirst();
                String takenLast = list.takeLast();
                System.out.printf("%s took  %s and %s from ends%n", Thread.currentThread().getName(), takenFirst, takenLast);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

package ch12.concurrency.nbcon;

import java.util.concurrent.ConcurrentLinkedDeque;


/**
 * Main class of the example. First, execute 100 AddTask objects to add 1000000
 * elements to the list and the execute 100 PollTask objects to delete all those
 * elements.
 */
public class Main {

    /**
     * Main method of the class
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {

        // Create a ConcurrentLinkedDeque to work with it in the example
        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();

        final int max = 100;
        // Create an Array of 100 threads
        Thread addThreads[] = new Thread[max];

        // Create an Array of 100 threads
        Thread pollThreads[] = new Thread[max];

        // Create 100 AddTask and PollTask objects and execute them as threads
        for (int i = 0; i < max; i++) {
            AddTask addtask = new AddTask(list);
            addThreads[i] = new Thread(addtask);
            addThreads[i].start();

            PollTask pollTask = new PollTask(list);
            pollThreads[i] = new Thread(pollTask);
            pollThreads[i].start();
        }
        System.out.printf("Main: %d AddTask threads have been launched\n", max);

        // Wait for the finalization of the threads
        for (int i = 0; i < addThreads.length; i++) {
            addThreads[i].join();
        }

        // Wait for the finalization of the threads
        for (int i = 0; i < pollThreads.length; i++) {
            pollThreads[i].join();
        }

        // Write to the console the size of the list
        System.out.printf("Main: Size of the List: %d\n", list.size());
    }
}

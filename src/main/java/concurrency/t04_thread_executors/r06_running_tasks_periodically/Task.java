package concurrency.t04_thread_executors.r06_running_tasks_periodically;

import java.util.Date;

public class Task implements Runnable {

    /**
     * Name of the task
     */
    private final String name;

    /**
     * Constructor of the class
     * @param name the name of the class
     */
    public Task(String name) {
        this.name=name;
    }

    /**
     * Main method of the example. Writes a message to the console with the actual
     * date
     */
    @Override
    public void run() {
        System.out.printf("%s: Executed at: %s\n",name,new Date());
    }

}

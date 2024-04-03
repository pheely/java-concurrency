package concurrency.t01_thread_management.r04_wait;

import java.util.Date;

public class Main {
    public static void main(String args[]) {
        Thread thread1 = new Thread(new DataSourcesLoader());
        Thread thread2 = new Thread(new NetworkConnectionsLoader());
        Thread thread3 = new Thread(new LongRunningInitialization());
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            // only wait for thread3 until 10 second
            thread3.join(10000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.printf("Main: initialization tasks complete: %s\n", new Date());
    }
}

package concurrency.t01_thread_management.r09_thread_factory;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

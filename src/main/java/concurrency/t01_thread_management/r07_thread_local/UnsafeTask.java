package concurrency.t01_thread_management.r07_thread_local;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {
    private Date startDate;
    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate);
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random() * 10));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate);
    }
}

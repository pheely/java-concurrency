package concurrency.t01_thread_management.r07_thread_local;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {
    private ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random() * 10));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate.get());
    }
}
